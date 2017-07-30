package com.example.dagger2training;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.example.dagger2training.network.GithubService;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class GithubApplication extends Application {

    private GithubApplicationComponent component;

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    private GithubService githubService;

    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        githubService = component.getGithubService();
        picasso = component.getPicasso();
    }

    public GithubApplicationComponent component() {
        return component;
    }

}