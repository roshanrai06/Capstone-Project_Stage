package com.roshanrai.filmophile.model.dao;

public interface DaoListener<ENTITY> {

    void onLoad(ENTITY entity);

}
