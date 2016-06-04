package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.presenter.ListPopularMoviesPresenter;
import com.roshanrai.filmophile.view.ListPopularMoviesView;
import com.roshanrai.filmophile.view.activity.ListPopularMoviesActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = ListPopularMoviesActivity.class)
public class ListPopularMoviesViewModule {

    ListPopularMoviesView view;

    public ListPopularMoviesViewModule(ListPopularMoviesView view) {
        this.view = view;
    }

    @Provides
    public ListPopularMoviesPresenter provideListPopularMoviesPresenter(MovieApi movieApi) {
        return new ListPopularMoviesPresenter(view, movieApi);
    }
}
