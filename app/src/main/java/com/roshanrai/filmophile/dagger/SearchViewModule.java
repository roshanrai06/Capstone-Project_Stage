package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.MovieApi;
import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.presenter.SearchPresenter;
import com.roshanrai.filmophile.view.SearchView;
import com.roshanrai.filmophile.view.activity.SearchActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class}, injects = SearchActivity.class)
public class SearchViewModule {

    private SearchView view;

    public SearchViewModule(SearchView view) {
        this.view = view;
    }

    @Provides
    public SearchPresenter provideSearchPresenter(MovieApi movieApi, PersonApi personApi) {
        return new SearchPresenter(view, movieApi, personApi);
    }

}
