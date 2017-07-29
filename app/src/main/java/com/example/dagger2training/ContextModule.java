package com.example.dagger2training;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    public ContextModule(Context context) {
        this.context = context;
    }

    private final Context context;

    @Provides
    @GithubApplicationScope
    @ApplicationContext
    public Context context() {
        return context;
    }
}