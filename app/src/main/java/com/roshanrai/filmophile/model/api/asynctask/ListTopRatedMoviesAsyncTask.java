package com.roshanrai.filmophile.model.api.asynctask;

import android.content.Context;

import com.roshanrai.filmophile.model.api.asynctask.exception.BadRequestException;
import com.roshanrai.filmophile.model.api.resource.MovieResource;
import com.roshanrai.filmophile.model.entity.Movie;

import java.util.List;

import retrofit.Response;

import static java.net.HttpURLConnection.HTTP_OK;

public class ListTopRatedMoviesAsyncTask extends GenericAsyncTask<Void, Void, List<Movie>> {

    private MovieResource movieResource;
    private Integer page;

    public ListTopRatedMoviesAsyncTask(Context context, MovieResource movieResource, Integer page) {
        super(context);
        this.movieResource = movieResource;
        this.page = page;
    }

    @Override
    protected AsyncTaskResult<List<Movie>> doInBackground(Void... params) {

        try {
            Response<List<Movie>> response = movieResource.listTopRated(getApiKey(), page).execute();
            switch (response.code()) {
                case HTTP_OK:
                    return new AsyncTaskResult<>(response.body());
                default:
                    return new AsyncTaskResult<>(new BadRequestException());
            }
        } catch (Exception ex) {
            return new AsyncTaskResult<>(new BadRequestException());
        }

    }
}
