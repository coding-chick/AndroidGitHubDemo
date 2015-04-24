package net.codingchick.androidgithubdemo.core;

import android.os.AsyncTask;

import net.codingchick.androidgithubdemo.model.Owner;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.model.RootObject;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void searchRepos(String searchString, String languageString,  final SearchReposCallback callback) {
        new AsyncTask<String, Void, ArrayList<Repo>>() {
            @Override
            protected ArrayList<Repo> doInBackground(String... params) {
                final String searchQuery = params[0];
                final String languageFilter = params[1];

                if (AppConnectivityManager.isConnectedToInternet()){
                    String fullSearch = searchQuery;
                    if (languageFilter != null){
                        fullSearch += "+language:" + languageFilter;
                    }

                    RootObject reposResult = githubService.searchRepos(fullSearch);

                    if (reposResult != null) {
                        for(Repo currRepo : reposResult.getItems()){
                            currRepo.getOwner().setOwnerId(currRepo.getOwner().getId());
                            currRepo.getOwner().setId(null);
                            currRepo.getOwner().save();

                            currRepo.setRepoId(currRepo.getId());
                            currRepo.setId(null);
                            currRepo.save();
                        }
                    }

                    return reposResult.getItems();
                }
                else{
                    String fullQuery = String.format("Select * from Repo where name LIKE '%%%s%%'", searchQuery);
                    if (languageFilter != null){
                        fullQuery += String.format(" AND language = '%s'", languageFilter);
                    }

                    List<Repo> prevSearches = Repo.findWithQuery(Repo.class, fullQuery);
                    return new ArrayList<Repo>(prevSearches);
                }

            }

            @Override
            protected void onPostExecute(ArrayList<Repo> repos) {
                callback.onResult(repos);
            }

        }.execute(searchString, languageString);

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
