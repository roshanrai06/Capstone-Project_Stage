package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.presenter.ListUpcomingMoviesPresenter;
import com.roshanrai.filmophile.view.ListUpcomingMoviesView;
import com.roshanrai.filmophile.view.activity.ListUpcomingMoviesActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = ListUpcomingMoviesActivity.class)
public class ListUpcomingMoviesViewModule {

    ListUpcomingMoviesView view;

    public ListUpcomingMoviesViewModule(ListUpcomingMoviesView view) {
        this.view = view;
    }

    @Provides
    public ListUpcomingMoviesPresenter provideListUpcomingMoviesPresenter(MovieApi movieApi) {
        return new ListUpcomingMoviesPresenter(view, movieApi);
    }
}
