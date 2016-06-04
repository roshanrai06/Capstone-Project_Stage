package com.roshanrai.filmophile.dagger;

import com.roshanrai.filmophile.model.api.ReviewApi;
import com.roshanrai.filmophile.presenter.ListReviewPresenter;
import com.roshanrai.filmophile.view.ListReviewView;
import com.roshanrai.filmophile.view.fragment.ListReviewFragment;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = {AppModule.class, ApiModule.class}, injects = ListReviewFragment.class)
public class ListReviewViewModule {

    private ListReviewView view;

    public ListReviewViewModule(ListReviewView view) {
        this.view = view;
    }

    @Provides
    public ListReviewPresenter provideListReviewPresenter(ReviewApi reviewApi) {
        return new ListReviewPresenter(view, reviewApi);
    }
}
