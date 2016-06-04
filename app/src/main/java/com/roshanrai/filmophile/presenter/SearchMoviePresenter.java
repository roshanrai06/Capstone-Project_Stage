package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.view.SearchMovieView;

import java.util.List;

public class SearchMoviePresenter {

    private SearchMovieView view;
    private MovieApi movieApi;

    public SearchMoviePresenter(SearchMovieView view, MovieApi movieApi) {
        this.view = view;
        this.movieApi = movieApi;
    }

    public void search(String query, Integer page) {
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

        movieApi.listByName(query, page);
    }


    public void stop() {
        movieApi.cancelAllServices();
    }
}
