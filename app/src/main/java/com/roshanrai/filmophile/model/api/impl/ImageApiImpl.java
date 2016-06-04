package com.roshanrai.filmophile.model.api.impl;

import android.content.Context;
import android.os.AsyncTask;

import com.roshanrai.filmophile.model.api.GenericApi;
import com.roshanrai.filmophile.model.api.ImageApi;
import com.roshanrai.filmophile.model.api.asynctask.ListImageByMovieAsyncTask;
import com.roshanrai.filmophile.model.api.asynctask.ListImageByPersonAsyncTask;
import com.roshanrai.filmophile.model.api.resource.ImageResource;
import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.Person;

public class ImageApiImpl extends GenericApi implements ImageApi {

    private ImageResource imageResource;
    private ListImageByMovieAsyncTask listImageByMovieAsyncTask;
    private ListImageByPersonAsyncTask listImageByPersonAsyncTask;

    public ImageApiImpl(Context context, ImageResource imageResource) {
        super(context);
        this.imageResource = imageResource;
    }

    @Override
    public void listAllByMovie(Movie movie) {
        verifyServiceResultListener();
        listImageByMovieAsyncTask = new ListImageByMovieAsyncTask(getContext(), imageResource, movie);
        listImageByMovieAsyncTask.setApiResultListener(getApiResultListener());
        listImageByMovieAsyncTask.execute();
    }

    @Override
    public void listAllByPerson(Person person) {
        verifyServiceResultListener();
        listImageByPersonAsyncTask = new ListImageByPersonAsyncTask(getContext(), imageResource, person);
        listImageByPersonAsyncTask.setApiResultListener(getApiResultListener());
        listImageByPersonAsyncTask.execute();
    }

    @Override
    public void cancelAllServices() {
        if(listImageByMovieAsyncTask != null && listImageByMovieAsyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            listImageByMovieAsyncTask.cancel(true);
        }
        if(listImageByPersonAsyncTask != null && listImageByPersonAsyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            listImageByPersonAsyncTask.cancel(true);
        }
    }
}
