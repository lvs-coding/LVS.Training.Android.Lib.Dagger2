package com.example.dagger2training;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    @ApplicationContext
    public Context context() {
        return  context;
    }
}
