package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.GenreApi;
import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.MovieWatchedDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.presenter.UserDetailPresenter;
import com.roshanrai.filmophile.view.UserDetailView;
import com.roshanrai.filmophile.view.fragment.UserDetailFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = UserDetailFragment.class, includes = {AppModule.class, ApiModule.class, DaoModule.class})
public class UserDetailViewModule {

    private UserDetailView view;

    public UserDetailViewModule(UserDetailView view) {
        this.view = view;
    }

    @Provides
    public UserDetailPresenter provideUserDetailPresenter(UserDao userDao, MovieInterestDao movieInterestDao, MovieWatchedDao movieWatchedDao, GenreApi genreApi) {
        return new UserDetailPresenter(view, userDao, movieInterestDao, movieWatchedDao, genreApi);
    }
}
