package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Movie;

import java.util.List;

public interface PersonWorkView {
    void hideLoadingWorkAsCrew();

    void showLoadingWorkAsCrew();

    void showWorksAsCrew(List<Movie> crewMovieList);

    void warnAnyWorkAsCrewFounded();

    void warnFailedToLoadWorkAsCrew();

    void showLoadingWorkAsCast();

    void warnAnyWorkAsCastFounded();

    void showWorksAsCast(List<Movie> castMovieList);

    void hideLoadingWorkAsCast();

    void warnFailedToLoadWorkAsCast();
}
