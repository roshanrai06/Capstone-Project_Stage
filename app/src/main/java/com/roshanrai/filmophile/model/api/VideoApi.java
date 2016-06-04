package com.roshanrai.filmophile.model.api;

import com.roshanrai.filmophile.model.entity.Movie;

public interface VideoApi extends AsyncService {
    void listAllByMovie(Movie movie);
}
