package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.presenter.UserPerfilPresenter;
import com.roshanrai.filmophile.view.UserProfileView;
import com.roshanrai.filmophile.view.activity.UserProfileActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = {UserProfileActivity.class}, includes = {AppModule.class, ApiModule.class, DaoModule.class})
public class UserProfileViewModule {

    private UserProfileView view;

    public UserProfileViewModule(UserProfileView view) {
        this.view = view;
    }

    @Provides
    public UserPerfilPresenter provideUserPresenter(UserDao userDao) {
        return new UserPerfilPresenter(view, userDao);
    }
}
