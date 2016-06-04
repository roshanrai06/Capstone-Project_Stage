package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.view.ListPopularMoviesView;

import java.util.List;

public class ListPopularMoviesPresenter {

    private ListPopularMoviesView view;
    private MovieApi movieApi;

    public ListPopularMoviesPresenter(ListPopularMoviesView view, MovieApi movieApi) {
        this.view = view;
        this.movieApi = movieApi;
    }

    public void loadMovies(Integer page) {
        view.showLoadingMovies();
        movieApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                List<Movie> movieList = (List<Movie>) object;
                if (movieList == null || movieList.size() == 0) {
                    view.warnAnyMovieFounded();
                } else {
                    view.showMovies(movieList);
                }
                view.hideLoadingMovies();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedToLoadMovies();
                view.hideLoadingMovies();
            }
        });

        movieApi.listPopularMovies(page);
    }


    public void stop() {
        movieApi.cancelAllServices();
    }
}
