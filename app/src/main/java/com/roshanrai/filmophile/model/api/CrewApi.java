package com.roshanrai.filmophile.model.api;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.Person;

public interface CrewApi extends AsyncService{
    void listAllByMovie(Movie movie);

    void listMoviesByCrew(Person person);
}
