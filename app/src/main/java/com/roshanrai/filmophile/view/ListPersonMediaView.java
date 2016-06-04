package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Image;
import com.roshanrai.filmophile.model.entity.Media;

import java.util.List;

public interface ListPersonMediaView {
    void warnAnyMediaFounded();

    void showMedias(List<Media> mediaList);

    void showLoadingMedias();

    void hideLoadingMedias();

    void warnFailedToLoadMedias();

    void showImages(List<Image> imageList);
}
