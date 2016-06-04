package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.ImageApi;
import com.roshanrai.filmophile.presenter.ListPersonMediaPresenter;
import com.roshanrai.filmophile.view.ListPersonMediaView;
import com.roshanrai.filmophile.view.fragment.ListPersonMediaFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class}, injects = ListPersonMediaFragment.class)
public class ListPersonMediaViewModule {

    private ListPersonMediaView view;

    public ListPersonMediaViewModule(ListPersonMediaView view) {
        this.view = view;
    }

    @Provides
    public ListPersonMediaPresenter provideListPersonMediaPresenter(ImageApi imageApi) {
        return new ListPersonMediaPresenter(view, imageApi);
    }
}
