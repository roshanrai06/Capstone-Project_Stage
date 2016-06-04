package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.presenter.PersonDetailPresenter;
import com.roshanrai.filmophile.view.PersonDetailView;
import com.roshanrai.filmophile.view.fragment.PersonDetailFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = PersonDetailFragment.class, includes = {AppModule.class, ApiModule.class})
public class PersonDetailViewModule {

    private PersonDetailView view;

    public PersonDetailViewModule(PersonDetailView view) {
        this.view = view;
    }

    @Provides
    public PersonDetailPresenter providePersonDetailPresenter(PersonApi personApi) {
        return new PersonDetailPresenter(view, personApi);
    }
}
