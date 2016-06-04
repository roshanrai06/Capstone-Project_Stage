package com.roshanrai.filmophile.view;

import com.roshanrai.filmophile.model.entity.Person;

import java.util.List;

public interface SearchPersonView {
    void showLoadingPerson();

    void warnAnyPersonFounded();

    void showPerson(List<Person> personList);

    void hideLoadingPerson();

    void warnFailedToLoadPerson();
}
