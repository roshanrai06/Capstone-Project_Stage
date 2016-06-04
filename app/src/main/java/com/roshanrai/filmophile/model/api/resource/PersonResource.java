package com.roshanrai.filmophile.model.api.resource;


import com.roshanrai.filmophile.model.entity.Person;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface PersonResource {

    @GET("person/{id}")
    Call<Person> findById(@Path("id") Long personId, @Query("api_key") String apiKey);

    @GET("search/person")
    Call<List<Person>> listByName(@Query("api_key") String apiKey, @Query("query") String query, @Query("page") int page);


}
