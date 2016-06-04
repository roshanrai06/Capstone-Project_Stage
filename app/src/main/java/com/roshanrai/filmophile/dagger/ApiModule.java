package com.roshanrai.filmophile.dagger;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.roshanrai.filmophile.R;
import com.roshanrai.filmophile.model.api.CastApi;
import com.roshanrai.filmophile.model.api.CrewApi;
import com.roshanrai.filmophile.model.api.GenreApi;
import com.roshanrai.filmophile.model.api.ImageApi;
import com.roshanrai.filmophile.model.api.ItemTypeAdapterFactory;
import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.model.api.ReviewApi;
import com.roshanrai.filmophile.model.api.VideoApi;
import com.roshanrai.filmophile.model.api.impl.CastApiImpl;
import com.roshanrai.filmophile.model.api.impl.CrewApiImpl;
import com.roshanrai.filmophile.model.api.impl.GenreApiImpl;
import com.roshanrai.filmophile.model.api.impl.ImageApiImpl;
import com.roshanrai.filmophile.model.api.impl.MovieApiImpl;
import com.roshanrai.filmophile.model.api.impl.PersonApiImpl;
import com.roshanrai.filmophile.model.api.impl.ReviewApiImpl;
import com.roshanrai.filmophile.model.api.impl.VideoApiImpl;
import com.roshanrai.filmophile.model.api.resource.CastResource;
import com.roshanrai.filmophile.model.api.resource.CrewResource;
import com.roshanrai.filmophile.model.api.resource.GenreResource;
import com.roshanrai.filmophile.model.api.resource.ImageResource;
import com.roshanrai.filmophile.model.api.resource.MovieResource;
import com.roshanrai.filmophile.model.api.resource.PersonResource;
import com.roshanrai.filmophile.model.api.resource.ReviewResource;
import com.roshanrai.filmophile.model.api.resource.VideoResource;
import com.roshanrai.filmophile.util.JsonDateDeserializer;

import java.util.Arrays;
import java.util.Date;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

@Module(library = true, includes = AppModule.class)
public class ApiModule {

    @Provides
    public Retrofit provideRetrofit(Context context) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .registerTypeAdapter(Date.class, new JsonDateDeserializer())
                .create();

        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.themoviedbapi_baseurl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    public MovieResource provideMovieResource(Context context) {
        return provideRetrofit(context).create(MovieResource.class);
    }

    @Provides
    public VideoResource provideVideoResource(Context context) {
        return provideRetrofit(context).create(VideoResource.class);
    }

    @Provides
    public PersonResource providePersonResource(Context context) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .registerTypeAdapter(Date.class, new JsonDateDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.themoviedbapi_baseurl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(PersonResource.class);
    }

    @Provides
    public ReviewResource provideReviewResource(Context context) {
        return provideRetrofit(context).create(ReviewResource.class);
    }

    @Provides
    public CastResource provideCastResource(Context context) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory("cast"))
                .registerTypeAdapter(Date.class, new JsonDateDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.themoviedbapi_baseurl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(CastResource.class);
    }

    @Provides
    public CrewResource provideCrewResource(Context context) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory("crew"))
                .registerTypeAdapter(Date.class, new JsonDateDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.themoviedbapi_baseurl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(CrewResource.class);
    }

    @Provides
    public GenreResource provideGenreResource(Context context) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory("genres"))
                .registerTypeAdapter(Date.class, new JsonDateDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.themoviedbapi_baseurl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GenreResource.class);
    }

    @Provides
    public ImageResource provideImageResource(Context context) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory(Arrays.asList("backdrops", "posters", "profiles")))
                .registerTypeAdapter(Date.class, new JsonDateDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.themoviedbapi_baseurl))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ImageResource.class);
    }

    @Provides
    public MovieApi provideMovieApi(Context context) {
        return new MovieApiImpl(context, provideMovieResource(context));
    }

    @Provides
    public CastApi provideCastApi(Context context) {
        return new CastApiImpl(context, provideCastResource(context));
    }

    @Provides
    public CrewApi provideCrewApi(Context context) {
        return new CrewApiImpl(context, provideCrewResource(context));
    }

    @Provides
    public GenreApi provideGenreApi(Context context) {
        return new GenreApiImpl(context, provideGenreResource(context));
    }

    @Provides
    public ReviewApi provideReviewApi(Context context) {
        return new ReviewApiImpl(context, provideReviewResource(context));
    }

    @Provides
    public VideoApi provideVideoApi(Context context) {
        return new VideoApiImpl(context, provideVideoResource(context));
    }

    @Provides
    public ImageApi provideImageApi(Context context) {
        return new ImageApiImpl(context, provideImageResource(context));
    }

    @Provides
    public PersonApi providePersonApi(Context context) {
        return new PersonApiImpl(context, providePersonResource(context));
    }
}
