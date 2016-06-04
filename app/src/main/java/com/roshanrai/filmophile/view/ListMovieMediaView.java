package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Image;
import com.roshanrai.filmophile.model.entity.Media;
import com.roshanrai.filmophile.model.entity.Video;

import java.util.List;

public interface ListMovieMediaView {
    void warnAnyMediaFounded();

    void showLoadingMedias();

    void showVideos(List<Video> videoList);

    void showMedias(List<Media> mediaList);

    void hideLoadingMedias();

    void warnFailedToLoadMedias();

    void showImages(List<Image> imageList);
}
