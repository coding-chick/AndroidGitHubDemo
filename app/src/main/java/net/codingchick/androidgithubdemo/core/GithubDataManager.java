package net.codingchick.androidgithubdemo.core;

import android.os.AsyncTask;

import net.codingchick.androidgithubdemo.model.Repo;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by Efrat Barak on 4/19/2015.
 */
public class GithubDataManager {
    private GithubService githubService;

    private GithubDataManager() {
        githubService =  new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build()
                .create(GithubService.class);
    }

    public void searchRepos(String searchString, final SearchReposCallback callback) {
        new AsyncTask<String, Void, ArrayList<Repo>>() {
            @Override
            protected ArrayList<Repo> doInBackground(String... params) {
                return githubService.searchRepos(params[0]).getItems();
            }

            @Override
            protected void onPostExecute(ArrayList<Repo> repos) {
                callback.onResult(repos);
            }
        }.execute(searchString);

    }

    public interface SearchReposCallback {
        public void onResult(ArrayList<Repo> result);
    }

    private static GithubDataManager githubDataManager;
    public static GithubDataManager getInstance() {
        if (githubDataManager == null) {
            githubDataManager = new GithubDataManager();
        }

        return githubDataManager;
    }
}
