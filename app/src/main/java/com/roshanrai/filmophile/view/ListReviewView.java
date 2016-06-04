package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Review;

import java.util.List;

public interface ListReviewView {
    void warnAnyReviewFounded();

    void showLoadingReview();

    void showReviews(List<Review> reviewList);

    void showReviews();

    void hideLoadingReviews();

    void warnFailedToLoadReviews();
}
