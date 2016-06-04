package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.entity.Person;
import com.roshanrai.filmophile.view.SearchPersonView;

import java.util.List;

public class SearchPersonPresenter {

    private SearchPersonView view;
    private PersonApi personApi;

    public SearchPersonPresenter(SearchPersonView view, PersonApi personApi) {
        this.view = view;
        this.personApi = personApi;
    }

    public void search(String query, Integer page) {
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

        personApi.listByName(query, page);
    }


    public void stop() {
        personApi.cancelAllServices();
    }
}
