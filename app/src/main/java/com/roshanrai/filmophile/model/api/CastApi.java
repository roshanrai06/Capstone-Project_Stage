package com.roshanrai.filmophile.model.api;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.Person;

public interface CastApi extends AsyncService {
    void listAllByMovie(Movie movie);

    void listMoviesByCast(Person person);
}
