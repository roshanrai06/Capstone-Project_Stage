package com.roshanrai.filmophile.dagger;

import android.support.v4.app.FragmentActivity;

import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.presenter.ListMovieInterestsPresenter;
import com.roshanrai.filmophile.view.ListMovieInterestsView;
import com.roshanrai.filmophile.view.fragment.ListMovieInterestsFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class, DaoModule.class}, injects = ListMovieInterestsFragment.class)
public class ListMovieInterestViewModule {

    private ListMovieInterestsView view;
    private FragmentActivity activity;

    public ListMovieInterestViewModule(ListMovieInterestsView view, FragmentActivity activity) {
        this.view = view;
        this.activity = activity;
    }

    @Provides
    public ListMovieInterestsPresenter provideListMovieInterestsPresenter(MovieInterestDao movieInterestDao, UserDao userDao) {
        movieInterestDao.setActivity(activity);
        return new ListMovieInterestsPresenter(view, movieInterestDao, userDao);
    }
}
