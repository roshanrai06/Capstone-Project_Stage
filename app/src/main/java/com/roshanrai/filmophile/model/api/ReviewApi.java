package com.roshanrai.filmophile.model.api;

import com.roshanrai.filmophile.model.entity.Movie;

public interface ReviewApi extends AsyncService {
    void listByMovies(Movie movie, int page);
}
