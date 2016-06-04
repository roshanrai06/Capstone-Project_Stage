package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.MovieNotInterestDao;
import com.roshanrai.filmophile.model.dao.MovieWatchedDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.presenter.DiscoveryPresenter;
import com.roshanrai.filmophile.view.DiscoveryView;
import com.roshanrai.filmophile.view.activity.DiscoveryActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {ApiModule.class, DaoModule.class}, injects = DiscoveryActivity.class)
public class DiscoveryViewModule {

    private DiscoveryView view;

    public DiscoveryViewModule(DiscoveryView view) {
        this.view = view;
    }

    @Provides
    public DiscoveryPresenter provideDiscoveryPresenter(MovieApi movieApi, MovieWatchedDao movieWatchedDao,
                                                        MovieInterestDao movieInterestDao, UserDao userDao,
                                                        MovieNotInterestDao movieNotInterestDao) {
        return new DiscoveryPresenter(view, movieApi, movieWatchedDao, movieInterestDao, movieNotInterestDao, userDao);
    }
}
