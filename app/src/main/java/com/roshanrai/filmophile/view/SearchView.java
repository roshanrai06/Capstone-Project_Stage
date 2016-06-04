package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.Person;

import java.util.List;

public interface SearchView {
    void showLoadingMovies();

    void warnAnyMovieFounded();

    void showMovies(List<Movie> movieList);

    void hideLoadingMovies();

    void warnFailedToLoadMovies();

    void showLoadingPerson();

    void warnAnyPersonFounded();

    void showPerson(List<Person> personList);

    void hideLoadingPerson();

    void warnFailedToLoadPerson();
}
