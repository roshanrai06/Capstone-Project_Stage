package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Movie;

import java.util.List;

public interface ListNowPlayingMoviesView {
    void showLoadingMovies();

    void warnAnyMovieFounded();

    void showMovies(List<Movie> movieList);

    void hideLoadingMovies();

    void warnFailedToLoadMovies();
}
