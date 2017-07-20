package com.example.dagger2training;

import com.example.dagger2training.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = GithubServiceModule.class)
public interface GithubApplicationComponent {
    Picasso getPicasso();
    GithubService getGithubService();
}
