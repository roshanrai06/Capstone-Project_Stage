package com.roshanrai.filmophile.model.dao;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.MovieWatched;
import com.roshanrai.filmophile.model.entity.User;

import java.util.List;

public interface MovieWatchedDao extends DaoLoader {
    void listAll(User user);

    MovieWatched findByMovie(Movie movie, User user);

    List<Long> favoriteGenres(User user, int size);

    void remove(MovieWatched movieWatched);

    void remove(Movie movie, User user);

    void insert(MovieWatched movieWatched);

    void update(MovieWatched movieWatched);

    void save(MovieWatched movieWatched);
}
