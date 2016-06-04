package com.roshanrai.filmophile.model.dao;

import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.MovieNotInterest;
import com.roshanrai.filmophile.model.entity.User;

import java.util.List;

public interface MovieNotInterestDao {
    List<MovieNotInterest> listAll(User user);

    List<MovieNotInterest> listAllUpcoming(User user);

    MovieNotInterest findByMovie(Movie movie, User user);

    void remove(MovieNotInterest movieNotInterest);

    void remove(Movie movie, User user);

    void insert(MovieNotInterest movieNotInterest);
}
