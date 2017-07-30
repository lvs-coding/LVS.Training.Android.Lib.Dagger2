package com.example.dagger2training.screens;

import com.example.dagger2training.GithubApplicationComponent;
import com.example.dagger2training.network.GithubService;
import com.example.dagger2training.screens.home.AdapterRepos;

import dagger.Component;

@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {
    AdapterRepos adapterRepos();

   // GithubService githubService();
}
