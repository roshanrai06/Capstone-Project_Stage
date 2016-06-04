package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.dao.DaoListener;
import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.model.entity.MovieInterest;
import com.roshanrai.filmophile.view.ListMovieInterestsView;

import java.util.List;

public class ListMovieInterestsPresenter {

    private ListMovieInterestsView view;
    private MovieInterestDao movieInterestDao;
    private UserDao userDao;

    public ListMovieInterestsPresenter(ListMovieInterestsView view, MovieInterestDao movieInterestDao, UserDao userDao) {
        this.view = view;
        this.movieInterestDao = movieInterestDao;
        this.userDao = userDao;
    }

    public void loadMovieInterests() {
        movieInterestDao.setDaoListener(new DaoListener() {
            @Override
            public void onLoad(Object object) {
                List<MovieInterest> movieInterestList = (List<MovieInterest>) object;
                if(movieInterestList.size() == 0) {
                    view.warnAnyInterestFounded();
                } else {
                    view.showMovieInterests(movieInterestList);
                }
            }
        });
        movieInterestDao.listAll(userDao.getLoggedUser());
    }

    public void remove(MovieInterest movieInterest) {
        movieInterestDao.remove(movieInterest);
        view.warnMovieRemoved(movieInterest.getMovie());
    }
}
