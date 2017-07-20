package com.example.dagger2training;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.dagger2training.network.DateTimeConverter;
import com.example.dagger2training.network.GithubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;
import com.jakewharton.picasso.OkHttp3Downloader;

import java.io.File;


public class GithubApplication extends Application {

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    private GithubService githubService;
    private Picasso picasso;

    // __Dependencies tree__

    // Activity

    //GithubService     picasso

    //retrofit      OkHttpDownloader

    //GSON              okhttp

    //             logger      cache

    //             timber      file

    @Override
    public void onCreate() {
        super.onCreate();


        Timber.plant(new Timber.DebugTree());

        // group CONTEXT
        Context context = this;

        // group PICASSO
        picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();

        // group GSON
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        Gson gson = gsonBuilder.create();



    }

    public GithubService getGithubService() {
        return githubService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}