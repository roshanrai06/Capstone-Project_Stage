package com.roshanrai.filmophile.model.api.impl;

import android.content.Context;
import android.os.AsyncTask;

import com.roshanrai.filmophile.model.api.GenericApi;
import com.roshanrai.filmophile.model.api.ReviewApi;
import com.roshanrai.filmophile.model.api.asynctask.ListReviewByMovieAsyncTask;
import com.roshanrai.filmophile.model.api.resource.ReviewResource;
import com.roshanrai.filmophile.model.entity.Movie;

public class ReviewApiImpl extends GenericApi implements ReviewApi {

    private ReviewResource reviewResource;
    private ListReviewByMovieAsyncTask listReviewByMovieAsyncTask;

    public ReviewApiImpl(Context context, ReviewResource reviewResource) {
        super(context);
        this.reviewResource = reviewResource;
    }

    @Override
    public void listByMovies(Movie movie, int page) {
        verifyServiceResultListener();
        listReviewByMovieAsyncTask = new ListReviewByMovieAsyncTask(getContext(), reviewResource, movie, page);
        listReviewByMovieAsyncTask.setApiResultListener(getApiResultListener());
        listReviewByMovieAsyncTask.execute();
    }

    @Override
    public void cancelAllServices() {
        if(listReviewByMovieAsyncTask != null && listReviewByMovieAsyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            listReviewByMovieAsyncTask.cancel(true);
        }
    }
}
