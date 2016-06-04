package com.roshanrai.filmophile;

import android.support.multidex.MultiDexApplication;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.roshanrai.filmophile.dagger.ApiModule;
import com.roshanrai.filmophile.dagger.AppModule;
import com.roshanrai.filmophile.dagger.DaoModule;

import dagger.ObjectGraph;

public class FilmophileApplication extends MultiDexApplication {

    private ObjectGraph objectGraph;
    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(
                new Object[]{
                        new AppModule(FilmophileApplication.this),
                        new ApiModule(),
                        new DaoModule()
                }
        );

    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}
