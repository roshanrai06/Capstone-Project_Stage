package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.view.UserProfileView;

public class UserPerfilPresenter {

    private UserProfileView view;
    private UserDao userDao;

    public UserPerfilPresenter(UserProfileView view, UserDao userDao) {
        this.view = view;
        this.userDao = userDao;
    }

    public void init() {
        view.showUserName(userDao.getLoggedUser().getName());
    }
}
