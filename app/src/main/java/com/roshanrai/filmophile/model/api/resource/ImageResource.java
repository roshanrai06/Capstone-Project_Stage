package com.roshanrai.filmophile.model.api.resource;

import com.roshanrai.filmophile.model.entity.Image;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ImageResource {

    @GET("movie/{id}/images")
    Call<List<Image>> listByMovie(@Path("id") Long movieId, @Query("api_key") String apiKey);

    @GET("person/{id}/images")
    Call<List<Image>> listByPerson(@Path("id") Long personId, @Query("api_key") String apiKey);

}
