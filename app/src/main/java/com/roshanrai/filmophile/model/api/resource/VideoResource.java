package com.roshanrai.filmophile.model.api.resource;


import com.roshanrai.filmophile.model.entity.Video;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface VideoResource {

    @GET("movie/{id}/videos")
    Call<List<Video>> listAllByMovie(@Path("id") Long movieId, @Query("api_key") String apiKey);

}
