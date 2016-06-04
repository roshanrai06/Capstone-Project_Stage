package com.roshanrai.filmophile.presenter;

import com.roshanrai.filmophile.model.entity.Person;
import com.roshanrai.filmophile.view.PersonProfileView;

public class PersonProfilePresenter {

    private PersonProfileView view;

    public PersonProfilePresenter(PersonProfileView view) {
        this.view = view;
    }

    public void init(Person person) {
        view.showPersonName(person.getName());
    }
}
