package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.presenter.SearchPersonPresenter;
import com.roshanrai.filmophile.view.SearchPersonView;
import com.roshanrai.filmophile.view.activity.SearchPersonActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = ApiModule.class, injects = SearchPersonActivity.class)
public class SearchPersonViewModule {

    SearchPersonView view;

    public SearchPersonViewModule(SearchPersonView view) {
        this.view = view;
    }

    @Provides
    public SearchPersonPresenter provideSearchPersonPresenter(PersonApi movieApi) {
        return new SearchPersonPresenter(view, movieApi);
    }
}
