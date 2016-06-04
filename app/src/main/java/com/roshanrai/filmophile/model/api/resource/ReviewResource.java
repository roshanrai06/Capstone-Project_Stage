package com.roshanrai.filmophile.model.api.resource;

import com.roshanrai.filmophile.model.entity.Review;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ReviewResource {

    @GET("movie/{id}/reviews")
    Call<List<Review>> listByMovie(@Path("id") Long movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

}
