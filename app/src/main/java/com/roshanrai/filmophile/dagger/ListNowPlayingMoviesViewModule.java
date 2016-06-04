package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.presenter.ListNowPlayingMoviesPresenter;
import com.roshanrai.filmophile.view.ListNowPlayingMoviesView;
import com.roshanrai.filmophile.view.activity.ListNowPlayingMoviesActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = ListNowPlayingMoviesActivity.class)
public class ListNowPlayingMoviesViewModule {

    ListNowPlayingMoviesView view;

    public ListNowPlayingMoviesViewModule(ListNowPlayingMoviesView view) {
        this.view = view;
    }

    @Provides
    public ListNowPlayingMoviesPresenter provideListNowPlayingMoviesPresenter(MovieApi movieApi) {
        return new ListNowPlayingMoviesPresenter(view, movieApi);
    }
}
