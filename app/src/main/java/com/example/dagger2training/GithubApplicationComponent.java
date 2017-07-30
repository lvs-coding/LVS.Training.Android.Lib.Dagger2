package com.example.dagger2training;

import com.example.dagger2training.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;


@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();
}
