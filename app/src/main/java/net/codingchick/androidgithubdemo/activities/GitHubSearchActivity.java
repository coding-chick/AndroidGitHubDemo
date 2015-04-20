package net.codingchick.androidgithubdemo.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.core.GithubDataManager;
import net.codingchick.androidgithubdemo.model.Repo;

import java.util.ArrayList;
import java.util.List;


public class GitHubSearchActivity extends Activity implements GithubDataManager.SearchReposCallback {
    ImageButton searchButton;
    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_search);

        Spinner spinner = (Spinner) findViewById(R.id.filter_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        searchText = (EditText) findViewById(R.id.search_text);
        searchButton = (ImageButton) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new SearchClickedListener());
    }

    private class SearchClickedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String searchString = searchText.getText().toString();
            GithubDataManager.getInstance().searchRepos(searchString, GitHubSearchActivity.this);
        }
    }

    @Override
    public void onResult(ArrayList<Repo> result) {

    }
}
