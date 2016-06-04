package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.presenter.ListMoviesByGenrePresenter;
import com.roshanrai.filmophile.view.ListMoviesByGenreView;
import com.roshanrai.filmophile.view.activity.ListMoviesByGenreActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = ListMoviesByGenreActivity.class)
public class ListMoviesByGenreViewModule {

    ListMoviesByGenreView view;

    public ListMoviesByGenreViewModule(ListMoviesByGenreView view) {
        this.view = view;
    }

    @Provides
    public ListMoviesByGenrePresenter provideListMoviesByGenrePresenter(MovieApi movieApi) {
        return new ListMoviesByGenrePresenter(view, movieApi);
    }
}
