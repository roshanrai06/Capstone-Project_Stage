package com.roshanrai.filmophile.model.dao;

import com.roshanrai.filmophile.model.entity.User;

public interface UserDao {
    void save(User user);

    void update(User user);

    void insert(User user);

    void login(User user);

    User getLoggedUser();

    void logout();

    User findById(Integer id);

    User findByGoogleId(String googleId);

    boolean hasReadTutorial();

    void informHasReadTutorial();
}
