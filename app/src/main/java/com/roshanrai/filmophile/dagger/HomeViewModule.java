package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.presenter.HomePresenter;
import com.roshanrai.filmophile.view.HomeView;
import com.roshanrai.filmophile.view.activity.HomeActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {ApiModule.class, DaoModule.class}, injects = HomeActivity.class)
public class HomeViewModule {

    HomeView view;

    public HomeViewModule(HomeView view) {
        this.view = view;
    }

    @Provides
    public HomePresenter provideHomePresenter(MovieApi movieApi, UserDao userDao) {
        return new HomePresenter(view, movieApi, userDao);
    }

}
