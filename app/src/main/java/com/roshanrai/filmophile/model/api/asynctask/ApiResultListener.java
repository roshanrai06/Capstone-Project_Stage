package com.roshanrai.filmophile.model.api.asynctask;

public interface ApiResultListener {

    void onResult(Object object);

    void onException(Exception exception);

}
