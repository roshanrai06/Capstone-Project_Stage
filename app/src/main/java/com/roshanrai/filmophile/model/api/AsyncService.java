package com.roshanrai.filmophile.model.api;

import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;

public interface AsyncService {

    ApiResultListener getApiResultListener();

    void setApiResultListener(ApiResultListener listener);

    void cancelAllServices();
}
