package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.view.MovieProfileView;

public class MovieProfilePresenter {

    private MovieProfileView view;

    public MovieProfilePresenter(MovieProfileView view) {
        this.view = view;
    }

    public void init(Movie movie) {
        view.showMovieName(movie.getTitle());
    }
}
