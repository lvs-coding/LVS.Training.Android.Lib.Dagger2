package com.example.dagger2training.screens;


import com.example.dagger2training.screens.home.AdapterRepos;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    private final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public AdapterRepos adapterRepos(Picasso picasso) {
        return new AdapterRepos(homeActivity, picasso);
    }
}
