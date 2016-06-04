package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.presenter.PersonProfilePresenter;
import com.roshanrai.filmophile.view.PersonProfileView;
import com.roshanrai.filmophile.view.activity.PersonProfileActivity;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = {PersonProfileActivity.class}, includes = {AppModule.class, ApiModule.class})
public class PersonProfileViewModule {

    private PersonProfileView view;

    public PersonProfileViewModule(PersonProfileView view) {
        this.view = view;
    }

    @Provides
    public PersonProfilePresenter providePersonProfilePresenter() {
        return new PersonProfilePresenter(view);
    }
}
