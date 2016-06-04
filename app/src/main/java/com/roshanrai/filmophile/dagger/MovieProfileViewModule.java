package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.presenter.MovieProfilePresenter;
import com.roshanrai.filmophile.view.MovieProfileView;
import com.roshanrai.filmophile.view.activity.MovieProfileActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = {MovieProfileActivity.class}, includes = {AppModule.class, ApiModule.class})
public class MovieProfileViewModule {

    private MovieProfileView view;

    public MovieProfileViewModule(MovieProfileView view) {
        this.view = view;
    }

    @Provides
    public MovieProfilePresenter provideProfilePresenter() {
        return new MovieProfilePresenter(view);
    }
}
