package com.roshanrai.filmophile.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.roshanrai.filmophile.FilmophileApplication;
import com.roshanrai.filmophile.R;
import com.roshanrai.filmophile.dagger.ListPersonMediaViewModule;
import com.roshanrai.filmophile.model.entity.Image;
import com.roshanrai.filmophile.model.entity.Media;
import com.roshanrai.filmophile.model.entity.Person;
import com.roshanrai.filmophile.model.entity.Video;
import com.roshanrai.filmophile.presenter.ListPersonMediaPresenter;
import com.roshanrai.filmophile.view.ListPersonMediaView;
import com.roshanrai.filmophile.view.activity.FullImageSliderActivity;
import com.roshanrai.filmophile.view.adapter.ListViewAdapterWithPagination;
import com.roshanrai.filmophile.view.adapter.MediaListAdapter;
import com.roshanrai.filmophile.view.adapter.OnItemClickListener;
import com.roshanrai.filmophile.view.adapter.OnShowMoreListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListPersonMediaFragment extends Fragment implements ListPersonMediaView {

    private static final String BUNDLE_KEY_PAGE = "bundle_key_page";
    private final int itensPerPage = 10;
    private int scrollToItem;
    private Integer page = 1;
    private Integer numberOfColumns = 2;

    @Bind(R.id.recyclerview_media)
    RecyclerView recyclerViewMedia;
    @Bind(R.id.progressbar)
    ProgressBar progressBar;
    @Bind(R.id.linearlayout_anyfounded)
    LinearLayout linearLayoutAnyFounded;
    @Bind(R.id.linearlayout_loadfailed)
    LinearLayout linearLayoutLoadFailed;

    @Inject
    ListPersonMediaPresenter presenter;
    private List<Media> mediaList;
    private Person person;
    private static final String BUNDLE_KEY_MEDIALIST = "bundle_key_medialist";
    private static final String KEY_PERSON = "PERSON";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((FilmophileApplication) getActivity().getApplication()).getObjectGraph()
                .plus(new ListPersonMediaViewModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listpersonmedia, container, false);
        ButterKnife.bind(this, view);

        person = getArguments().getParcelable(KEY_PERSON);

        if (mediaList == null && savedInstanceState != null) {
            mediaList = savedInstanceState.getParcelableArrayList(BUNDLE_KEY_MEDIALIST);
            page = savedInstanceState.getInt(BUNDLE_KEY_PAGE);
        }

        if (mediaList == null) {
            presenter.loadImages(person);
        } else if (mediaList.size() == 0) {
            warnAnyMediaFounded();
        } else {
            showMedias(mediaList);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Tracker defaultTracker = ((FilmophileApplication) getActivity().getApplication()).getDefaultTracker();
        defaultTracker.setScreenName("List Of Person Media Screen");
        defaultTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mediaList != null) {
            outState.putParcelableArrayList(BUNDLE_KEY_MEDIALIST, new ArrayList<>(mediaList));
        }
        outState.putInt(BUNDLE_KEY_PAGE, page);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showLoadingMedias() {
        progressBar.setVisibility(View.VISIBLE);
        linearLayoutAnyFounded.setVisibility(View.GONE);
        linearLayoutLoadFailed.setVisibility(View.GONE);
    }

    @Override
    public void warnAnyMediaFounded() {
        if (mediaList == null) {
            linearLayoutAnyFounded.setVisibility(View.VISIBLE);
            linearLayoutLoadFailed.setVisibility(View.GONE);
            recyclerViewMedia.setVisibility(View.GONE);
        } else {
            Toast.makeText(getActivity(), getActivity().getString(R.string.general_anyfounded), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void showImages(List<Image> imageList) {
        if (this.mediaList == null) {
            this.mediaList = new ArrayList<Media>(imageList);
        } else {
            this.mediaList.addAll(imageList);
        }
        showMedias(this.mediaList);
    }

    @Override
    public void showMedias(final List<Media> mediaList) {
        this.mediaList = mediaList;

        final ArrayList<Media> mediaListOfPage = new ArrayList<>();
        for (int i = 0; i < page * itensPerPage && i < this.mediaList.size(); i++) {
            mediaListOfPage.add(this.mediaList.get(i));
        }

        linearLayoutAnyFounded.setVisibility(View.GONE);
        linearLayoutLoadFailed.setVisibility(View.GONE);
        recyclerViewMedia.setVisibility(View.VISIBLE);
        final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position >= mediaListOfPage.size() ? numberOfColumns : 1;
            }
        });
        recyclerViewMedia.setLayoutManager(layoutManager);
        recyclerViewMedia.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMedia.setAdapter(new ListViewAdapterWithPagination(
                        new MediaListAdapter(mediaListOfPage, new OnItemClickListener<Media>() {
                            @Override
                            public void onClick(Media media, View view) {
                                if (media instanceof Video) {
                                    Intent intent = YouTubeStandalonePlayer.createVideoIntent(getActivity(), getString(R.string.youtube_credential), ((Video) media).getKey());
                                    startActivity(intent);
                                } else if (media instanceof Image) {
                                    ArrayList<Image> imageArrayList = new ArrayList<Image>();
                                    for (Media mediaOfList : mediaListOfPage) {
                                        if (mediaOfList instanceof Image) {
                                            imageArrayList.add((Image) mediaOfList);
                                        }
                                    }
                                    startActivity(FullImageSliderActivity.newIntent(getActivity(), imageArrayList, imageArrayList.indexOf(media)));
                                }
                            }

                            @Override
                            public void onLongClick(Media media, View view) {

                            }
                        }),
                        new OnShowMoreListener() {
                            @Override
                            public void showMore() {
                                scrollToItem = layoutManager.findFirstVisibleItemPosition();
                                page++;
                                showMedias(mediaList);
                            }
                        },
                        itensPerPage)
        );
        recyclerViewMedia.setNestedScrollingEnabled(false);
        recyclerViewMedia.scrollToPosition(scrollToItem);
    }

    @Override
    public void hideLoadingMedias() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void warnFailedToLoadMedias() {
        if (mediaList == null) {
            linearLayoutAnyFounded.setVisibility(View.GONE);
            linearLayoutLoadFailed.setVisibility(View.VISIBLE);
            linearLayoutLoadFailed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.loadImages(person);
                }
            });
            recyclerViewMedia.setVisibility(View.GONE);
        } else {
            Toast.makeText(getActivity(), getActivity().getString(R.string.general_failedtoload), Toast.LENGTH_SHORT).show();
        }
    }

    public static ListPersonMediaFragment newInstance(Person person) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_PERSON, person);
        ListPersonMediaFragment fragment = new ListPersonMediaFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
