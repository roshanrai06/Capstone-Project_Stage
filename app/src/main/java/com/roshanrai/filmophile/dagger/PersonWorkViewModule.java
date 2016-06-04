package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.CastApi;
import com.roshanrai.filmophile.model.api.CrewApi;
import com.roshanrai.filmophile.presenter.PersonWorkPresenter;
import com.roshanrai.filmophile.view.PersonWorkView;
import com.roshanrai.filmophile.view.fragment.PersonWorkFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class}, injects = PersonWorkFragment.class)
public class PersonWorkViewModule {

    private PersonWorkView view;

    public PersonWorkViewModule(PersonWorkView view) {
        this.view = view;
    }

    @Provides
    public PersonWorkPresenter providePersonWorkPresenter(CastApi castApi, CrewApi crewApi) {
        return new PersonWorkPresenter(view, castApi, crewApi);
    }

}
