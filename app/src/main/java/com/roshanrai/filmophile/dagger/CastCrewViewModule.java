package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.CastApi;
import com.roshanrai.filmophile.model.api.CrewApi;
import com.roshanrai.filmophile.presenter.CastCrewPresenter;
import com.roshanrai.filmophile.view.CastCrewView;
import com.roshanrai.filmophile.view.fragment.CastCrewFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class}, injects = CastCrewFragment.class)
public class CastCrewViewModule {

    private CastCrewView view;

    public CastCrewViewModule(CastCrewView view) {
        this.view = view;
    }

    @Provides
    public CastCrewPresenter provideCastCrewPresenter(CastApi castApi, CrewApi crewApi) {
        return new CastCrewPresenter(view, castApi, crewApi);
    }

}
