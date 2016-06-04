package com.roshanrai.filmophile.presenter;


import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.entity.Movie;
import com.roshanrai.filmophile.model.entity.Person;
import com.roshanrai.filmophile.view.SearchView;

import java.util.List;

public class SearchPresenter {

    private SearchView view;
    private MovieApi movieApi;
    private PersonApi personApi;

    public SearchPresenter(SearchView view, MovieApi movieApi, PersonApi personApi) {
        this.view = view;
        this.movieApi = movieApi;
        this.personApi = personApi;
    }

    public void searchMovies(String name) {
        view.showLoadingMovies();
        movieApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                List<Movie> movieList = (List<Movie>) object;
                if (movieList == null || movieList.size() == 0) {
                    view.warnAnyMovieFounded();
                } else {
                    view.showMovies(movieList);
                }
                view.hideLoadingMovies();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedToLoadMovies();
                view.hideLoadingMovies();
            }
        });
        movieApi.listByName(name);
    }

    public void searchPerson(String name) {
        view.showLoadingPerson();
        personApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                List<Person> personList = (List<Person>) object;
                if (personList == null || personList.size() == 0) {
                    view.warnAnyPersonFounded();
                } else {
                    view.showPerson(personList);
                }
                view.hideLoadingPerson();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedToLoadPerson();
                view.hideLoadingPerson();
            }
        });
        personApi.listByName(name);
    }

    public void stop() {
        personApi.cancelAllServices();
        movieApi.cancelAllServices();
    }
}
