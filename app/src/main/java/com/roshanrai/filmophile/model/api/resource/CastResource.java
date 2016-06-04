package com.roshanrai.filmophile.model.api.resource;


import com.roshanrai.filmophile.model.entity.Cast;
import com.roshanrai.filmophile.model.entity.Movie;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface CastResource {

    @GET("movie/{id}/credits")
    Call<List<Cast>> listAllByMovie(@Path("id") Long id, @Query("api_key") String apiKey);

    @GET("person/{id}/movie_credits")
    Call<List<Movie>> listMoviesByCast(@Path("id") Long personId, @Query("api_key") String apiKey);

}
