package net.codingchick.androidgithubdemo.core;

import android.os.AsyncTask;

import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.model.RootObject;

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
                String searchQuery = params[0];
                RootObject reposResult = githubService.searchRepos(searchQuery);

                //if (reposResult != null) {
                    reposResult.setSearchQuery(searchQuery);

                    new AsyncTask<RootObject, Void, Void>() {
                        @Override
                        protected Void doInBackground(RootObject... params) {
                            params[0].save();
                            return null;
                        }
                    }.execute(reposResult);
               // }
               // else{
                    List<RootObject> prevSearches = RootObject.find(RootObject.class, "search_query = ?", searchQuery);
                    if (prevSearches.size() > 0){
                        prevSearches.get(0).getItems();
                    }
               // }
                return reposResult.getItems();
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
