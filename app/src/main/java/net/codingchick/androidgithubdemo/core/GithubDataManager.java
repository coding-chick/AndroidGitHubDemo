package net.codingchick.androidgithubdemo.core;

import android.os.AsyncTask;

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

    public void searchRepos(String searchString, final SearchReposCallback callback) {
        new AsyncTask<String, Void, ArrayList<Repo>>() {
            @Override
            protected ArrayList<Repo> doInBackground(String... params) {
                final String searchQuery = params[0];
                RootObject reposResult = githubService.searchRepos(searchQuery);

                //if (reposResult != null) {

                   // new AsyncTask<RootObject, Void, Void>() {
                      //  @Override
                      //  protected Void doInBackground(RootObject... params) {
                            for(Repo currRepo : reposResult.getItems()){
                                List<Repo> repoInDb = Repo.find(Repo.class, "repo_Id = ?", String.valueOf(currRepo.getRepoId()));
                                if (repoInDb.size() > 0){
                                    repoInDb.get(0).delete();
                                }
                                currRepo.setRepoId(currRepo.getId());
                                currRepo.setId(null);
                                currRepo.save();
                            }
                         //   return null;
                       // }
                  //  }.execute(reposResult);
               // }
               // else{
                    List<Repo> prevSearches = Repo.findWithQuery(Repo.class, "Select * from Repo where name LIKE " + "'%" +searchQuery+"%'");
                    if (prevSearches.size() > 0){
                        return new ArrayList<Repo>(prevSearches);
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
