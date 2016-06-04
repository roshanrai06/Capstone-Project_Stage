package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.ImageApi;
import com.roshanrai.filmophile.model.api.VideoApi;
import com.roshanrai.filmophile.presenter.ListMovieMediaPresenter;
import com.roshanrai.filmophile.view.ListMovieMediaView;
import com.roshanrai.filmophile.view.fragment.ListMovieMediaFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class}, injects = ListMovieMediaFragment.class)
public class ListMovieMediaViewModule {

    private ListMovieMediaView view;

    public ListMovieMediaViewModule(ListMovieMediaView view) {
        this.view = view;
    }

    @Provides
    public ListMovieMediaPresenter provideListVideoPresenter(VideoApi videoApi, ImageApi imageApi) {
        return new ListMovieMediaPresenter(view, videoApi, imageApi);
    }
}
