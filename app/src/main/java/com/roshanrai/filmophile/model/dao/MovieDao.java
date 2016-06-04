package com.roshanrai.filmophile.model.dao;

import com.roshanrai.filmophile.model.entity.Movie;

import java.util.List;

public interface MovieDao {
    void save(Movie movie);

    void update(Movie movie);

    void insert(Movie movie);

    Movie findById(Long id);

    List<Movie> listAll();

    List<Movie> listAllUpcoming();
}
