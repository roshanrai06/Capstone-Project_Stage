package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.MovieInterest;

import java.util.List;

public interface ListMovieInterestsView {
    void showMovieInterests(List<MovieInterest> movieInterestList);

    void warnAnyInterestFounded();

    void warnMovieRemoved(Movie movie);
}
