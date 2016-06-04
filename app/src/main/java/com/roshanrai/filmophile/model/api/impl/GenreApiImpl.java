package com.roshanrai.filmophile.model.api.impl;

import android.content.Context;
import android.os.AsyncTask;

import com.roshanrai.filmophile.model.api.GenericApi;
import com.roshanrai.filmophile.model.api.GenreApi;
import com.roshanrai.filmophile.model.api.asynctask.ListAllMovieGenreAsyncTask;
import com.roshanrai.filmophile.model.api.resource.GenreResource;

public class GenreApiImpl extends GenericApi implements GenreApi {

    private GenreResource genreResource;
    private ListAllMovieGenreAsyncTask listAllMovieGenreAsyncTask;

    public GenreApiImpl(Context context, GenreResource genreResource) {
        super(context);
        this.genreResource = genreResource;
    }

    @Override
    public void listAllOfMovie() {
        verifyServiceResultListener();
        listAllMovieGenreAsyncTask = new ListAllMovieGenreAsyncTask(getContext(), genreResource);
        listAllMovieGenreAsyncTask.setApiResultListener(getApiResultListener());
        listAllMovieGenreAsyncTask.execute();
    }

    @Override
    public void cancelAllServices() {
        if(listAllMovieGenreAsyncTask != null && listAllMovieGenreAsyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            listAllMovieGenreAsyncTask.cancel(true);
        }
    }
}
