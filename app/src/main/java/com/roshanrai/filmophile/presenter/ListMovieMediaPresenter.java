package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.api.ImageApi;
import com.roshanrai.filmophile.model.api.VideoApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.entity.Image;
import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.Video;
import com.roshanrai.filmophile.view.ListMovieMediaView;

import java.util.List;

public class ListMovieMediaPresenter {

    private ListMovieMediaView view;
    private VideoApi videoApi;
    private ImageApi imageApi;

    public ListMovieMediaPresenter(ListMovieMediaView view, VideoApi videoApi, ImageApi imageApi) {
        this.view = view;
        this.videoApi = videoApi;
        this.imageApi = imageApi;
    }

    public void loadVideos(Movie movie) {
        view.showLoadingMedias();
        videoApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                List<Video> videoList = (List<Video>) object;
                if (videoList == null || videoList.size() == 0) {
                    view.warnAnyMediaFounded();
                } else {
                    view.showVideos(videoList);
                }
                view.hideLoadingMedias();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedToLoadMedias();
                view.hideLoadingMedias();
            }
        });
        videoApi.listAllByMovie(movie);
    }

    public void loadImages(Movie movie) {
        view.showLoadingMedias();
        imageApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                List<Image> imageList = (List<Image>) object;
                if (imageList == null || imageList.size() == 0) {
                    view.warnAnyMediaFounded();
                } else {
                    view.showImages(imageList);
                }
                view.hideLoadingMedias();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedToLoadMedias();
                view.hideLoadingMedias();
            }
        });
        imageApi.listAllByMovie(movie);
    }

    public void stop() {
        videoApi.cancelAllServices();
        imageApi.cancelAllServices();
    }
}
