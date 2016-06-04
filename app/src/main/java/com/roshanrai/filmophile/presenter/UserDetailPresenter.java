package com.roshanrai.filmophile.presenter;


import com.roshanrai.filmophile.model.api.GenreApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.MovieWatchedDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.model.entity.Genre;
import com.roshanrai.filmophile.model.entity.MovieInterest;
import com.roshanrai.filmophile.view.UserDetailView;

import java.util.ArrayList;
import java.util.List;

public class UserDetailPresenter {

    private static final int NUMBER_GENRE = 5;

    private UserDetailView view;
    private UserDao userDao;
    private MovieInterestDao movieInterestDao;
    private MovieWatchedDao movieWatchedDao;
    private GenreApi genreApi;

    public UserDetailPresenter(UserDetailView view, UserDao userDao, MovieInterestDao movieInterestDao, MovieWatchedDao movieWatchedDao, GenreApi genreApi) {
        this.view = view;
        this.userDao = userDao;
        this.movieInterestDao = movieInterestDao;
        this.movieWatchedDao = movieWatchedDao;
        this.genreApi = genreApi;
    }

    public void init() {
        view.showUser(userDao.getLoggedUser());
    }

    public void loadUpcomingInterests() {
        List<MovieInterest> movieInterestList = movieInterestDao.listAllUpcoming(userDao.getLoggedUser());
        if (movieInterestList == null || movieInterestList.size() == 0) {
            view.warnAnyInterestFound();
        } else {
            view.showUpcomingInterests(movieInterestList);
        }
    }

    public void loadGenres() {
        final List<Long> favoriteGenreIdList = movieWatchedDao.favoriteGenres(userDao.getLoggedUser(), NUMBER_GENRE);
        if (favoriteGenreIdList.size() == 0) {
            view.warnAnyGenreFounded();
            return;
        }
        view.showLoadingGenres();
        genreApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                List<Genre> genreList = (List<Genre>) object;
                if (genreList == null || genreList.size() == 0) {
                    view.warnAnyGenreFounded();
                } else {
                    List<Genre> genresOfTheMovieList = new ArrayList<>();
                    for (Genre genre : genreList) {
                        if (favoriteGenreIdList.contains(genre.getId())) {
                            genresOfTheMovieList.add(genre);
                        }
                    }
                    view.showGenres(genresOfTheMovieList);
                }
                view.hideLoadingGenres();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedOnLoadGenres();
                view.hideLoadingGenres();
            }
        });
        genreApi.listAllOfMovie();
    }

}
