package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.presenter.SearchMoviePresenter;
import com.roshanrai.filmophile.view.SearchMovieView;
import com.roshanrai.filmophile.view.activity.SearchMovieActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = SearchMovieActivity.class)
public class SearchMovieViewModule {

    SearchMovieView view;

    public SearchMovieViewModule(SearchMovieView view) {
        this.view = view;
    }

    @Provides
    public SearchMoviePresenter provideSearchMoviePresenter(MovieApi movieApi) {
        return new SearchMoviePresenter(view, movieApi);
    }
}
