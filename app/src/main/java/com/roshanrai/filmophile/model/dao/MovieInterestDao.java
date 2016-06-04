package com.roshanrai.filmophile.model.dao;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.MovieInterest;
import com.roshanrai.filmophile.model.entity.User;

import java.util.List;

public interface MovieInterestDao extends DaoLoader {
    void listAll(User user);

    List<MovieInterest> listAllUpcoming(User user);

    MovieInterest findByMovie(Movie movie, User user);

    void remove(MovieInterest movieInterest);

    void remove(Movie movie, User user);

    void insert(MovieInterest movieInterest);
}
