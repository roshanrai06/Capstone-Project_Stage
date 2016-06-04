package com.roshanrai.filmophile.presenter;


import com.roshanrai.filmophile.model.api.PersonApi;
import com.roshanrai.filmophile.model.api.asynctask.ApiResultListener;
import com.roshanrai.filmophile.model.entity.Person;
import com.roshanrai.filmophile.view.PersonDetailView;

public class PersonDetailPresenter {

    private PersonDetailView view;
    private PersonApi personApi;

    public PersonDetailPresenter(PersonDetailView view, PersonApi personApi) {
        this.view = view;
        this.personApi = personApi;
    }

    public void loadPerson(Long personId) {
        view.showLoading();
        personApi.setApiResultListener(new ApiResultListener() {
            @Override
            public void onResult(Object object) {
                if (object == null) {
                    view.warnPersonNotFound();
                } else {
                    Person person = (Person) object;
                    view.showPerson(person);
                }
                view.hideLoading();
            }

            @Override
            public void onException(Exception exception) {
                view.warnFailedToLoadPerson();
                view.hideLoading();
            }
        });
        personApi.findById(personId);
    }

}
