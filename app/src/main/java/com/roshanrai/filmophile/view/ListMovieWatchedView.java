package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.MovieWatched;

import java.util.List;

public interface ListMovieWatchedView {
    void showWatchedMovies(List<MovieWatched> movieWatchedList);

    void warnAnyWatchedMovieFounded();

    void warnMovieRemoved(Movie movie);
}
