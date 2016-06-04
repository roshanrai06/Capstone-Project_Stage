package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.dao.DaoListener;
import com.roshanrai.filmophile.model.dao.MovieWatchedDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.model.entity.MovieWatched;
import com.roshanrai.filmophile.view.ListMovieWatchedView;

import java.util.List;

public class ListMovieWatchedPresenter {

    private ListMovieWatchedView view;
    private MovieWatchedDao movieWatchedDao;
    private UserDao userDao;

    public ListMovieWatchedPresenter(ListMovieWatchedView view, MovieWatchedDao movieWatchedDao, UserDao userDao) {
        this.view = view;
        this.movieWatchedDao = movieWatchedDao;
        this.userDao = userDao;
    }

    public void loadMovieInterests() {
        movieWatchedDao.setDaoListener(new DaoListener() {
            @Override
            public void onLoad(Object object) {
                List<MovieWatched> movieWatchedList = (List<MovieWatched>) object;
                if(movieWatchedList.size() == 0) {
                    view.warnAnyWatchedMovieFounded();
                } else {
                    view.showWatchedMovies(movieWatchedList);
                }
            }
        });
        movieWatchedDao.listAll(userDao.getLoggedUser());
    }

    public void remove(MovieWatched movieWatched) {
        movieWatchedDao.remove(movieWatched);
        view.warnMovieRemoved(movieWatched.getMovie());
    }
}
