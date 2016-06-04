package com.roshanrai.filmophile.dagger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.roshanrai.filmophile.model.SqliteConnection;
import com.roshanrai.filmophile.model.dao.MovieDao;
import com.roshanrai.filmophile.model.dao.MovieInterestDao;
import com.roshanrai.filmophile.model.dao.MovieNotInterestDao;
import com.roshanrai.filmophile.model.dao.MovieWatchedDao;
import com.roshanrai.filmophile.model.dao.UserDao;
import com.roshanrai.filmophile.model.dao.impl.MovieDaoImpl;
import com.roshanrai.filmophile.model.dao.impl.MovieInterestDaoImpl;
import com.roshanrai.filmophile.model.dao.impl.MovieNotInterestDaoImpl;
import com.roshanrai.filmophile.model.dao.impl.MovieWatchedDaoImpl;
import com.roshanrai.filmophile.model.dao.impl.UserDaoImpl;

import dagger.Module;
import dagger.Provides;

@Module(library = true, includes = AppModule.class)
public class DaoModule {

    @Provides
    public SQLiteDatabase provideSqLiteDatabase(Context context) {
        return new SqliteConnection(context).getWritableDatabase();
    }

    @Provides
    public UserDao provideUserDao(Context context) {
        return new UserDaoImpl(context, provideSqLiteDatabase(context));
    }

    @Provides
    public MovieDao provideMovieDao(Context context) {
        return new MovieDaoImpl(context, provideSqLiteDatabase(context));
    }

    @Provides
    public MovieInterestDao provideMovieInterestDao(Context context) {
        return new MovieInterestDaoImpl(context, provideSqLiteDatabase(context),
                provideMovieDao(context), provideUserDao(context));
    }

    @Provides
    public MovieNotInterestDao provideMovieNotInterestDao(Context context) {
        return new MovieNotInterestDaoImpl(context, provideSqLiteDatabase(context),
                provideMovieDao(context), provideUserDao(context));
    }

    @Provides
    public MovieWatchedDao provideMovieWatchedDao(Context context) {
        return new MovieWatchedDaoImpl(context, provideSqLiteDatabase(context),
                provideMovieDao(context), provideUserDao(context));
    }
}
