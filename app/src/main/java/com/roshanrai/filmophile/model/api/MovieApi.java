package com.roshanrai.filmophile.model.api;

import com.roshanrai.filmophile.model.entity.Genre;

public interface MovieApi extends AsyncService {
    void listUpcomingMovies();

    void discoverMovies(int page);

    void listUpcomingMovies(int page);

    void listPopularMovies();

    void listPopularMovies(int page);

    void listTopRatedMovies();

    void listTopRatedMovies(int page);

    void listNowPlayingMovies();

    void listNowPlayingMovies(int page);

    void listByGenre(Genre genre, int page);

    void listByName(String name, int page);

    void listByName(String name);
}
