package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.presenter.ListTopRatedMoviesPresenter;
import com.roshanrai.filmophile.view.ListTopRatedMoviesView;
import com.roshanrai.filmophile.view.activity.ListTopRatedMoviesActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = ListTopRatedMoviesActivity.class)
public class ListTopRatedMoviesViewModule {

    ListTopRatedMoviesView view;

    public ListTopRatedMoviesViewModule(ListTopRatedMoviesView view) {
        this.view = view;
    }

    @Provides
    public ListTopRatedMoviesPresenter provideListTopRatedMoviesPresenter(MovieApi movieApi) {
        return new ListTopRatedMoviesPresenter(view, movieApi);
    }
}
