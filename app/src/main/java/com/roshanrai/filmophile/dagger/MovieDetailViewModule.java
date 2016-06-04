package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.GenreApi;
import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.MovieWatchedDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.presenter.MovieDetailPresenter;
import com.roshanrai.filmophile.view.MovieDetailView;
import com.roshanrai.filmophile.view.fragment.MovieDetailFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = MovieDetailFragment.class, includes = {AppModule.class, ApiModule.class, DaoModule.class})
public class MovieDetailViewModule {

    private MovieDetailView view;

    public MovieDetailViewModule(MovieDetailView view) {
        this.view = view;
    }

    @Provides
    public MovieDetailPresenter provideMovieDetailPresenter(GenreApi genreApi, MovieInterestDao movieInterestDao, MovieWatchedDao movieWatchedDao, UserDao userDao) {
        return new MovieDetailPresenter(view, genreApi, movieInterestDao, movieWatchedDao, userDao);
    }
}
