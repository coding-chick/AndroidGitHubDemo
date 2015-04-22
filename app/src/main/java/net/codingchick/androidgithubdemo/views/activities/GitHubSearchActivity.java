package net.codingchick.androidgithubdemo.views.activities;

import android.app.Activity;
import android.os.Bundle;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.views.fragments.GitHubSearchFragment;
import net.codingchick.androidgithubdemo.views.fragments.RepoDetailsFragment;


public class GitHubSearchActivity extends Activity implements GitHubSearchFragment.SearchFragmentManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_search);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.seach_fragment, GitHubSearchFragment.newInstance())
                .commit();
    }

    @Override
    public void navigateTo(Repo repo) {
        getFragmentManager().
                beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .add(R.id.seach_fragment, RepoDetailsFragment.newInstance(repo))
                .addToBackStack("toDetails")
        .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getActionBar().show();
    }
}
