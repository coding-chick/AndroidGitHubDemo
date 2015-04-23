package net.codingchick.androidgithubdemo.views.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.views.fragments.GitHubSearchFragment;
import net.codingchick.androidgithubdemo.views.fragments.RepoDetailsFragment;


public class GitHubSearchActivity extends Activity implements GitHubSearchFragment.SearchFragmentManager {

    private boolean isTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_search);

        if (findViewById(R.id.repo_details_fragment) != null) {
            isTwoPane = true;
        }
        else{
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.seach_fragment, GitHubSearchFragment.newInstance())
                    .commit();
        }

    }

    @Override
    public void navigateTo(Repo repo) {
        if (isTwoPane) {

//            Bundle arguments = new Bundle();
//            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            RepoDetailsFragment fragment = RepoDetailsFragment.newInstance(repo);
           // fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.repo_details_fragment, fragment)
                    .commit();
        }
        else {
            getFragmentManager().
                    beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .add(R.id.seach_fragment, RepoDetailsFragment.newInstance(repo))
                    .addToBackStack("toDetails")
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.seach_fragment);
        if (fragment != null) {
            fragment.onSaveInstanceState(outState);

            getFragmentManager().beginTransaction()
                    .remove( getFragmentManager().findFragmentById(R.id.seach_fragment))
                    .commit();
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getActionBar().show();
    }
}
