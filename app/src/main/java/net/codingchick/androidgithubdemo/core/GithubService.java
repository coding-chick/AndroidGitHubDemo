package net.codingchick.androidgithubdemo.core;

import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.model.RootObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Efrat Barak on 4/19/2015.
 */
public interface GithubService {
    @GET("/search/repositories")
    RootObject searchRepos(@Query("q") String searchString);
}
