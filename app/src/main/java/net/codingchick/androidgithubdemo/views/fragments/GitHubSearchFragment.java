package net.codingchick.androidgithubdemo.views.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.core.GithubDataManager;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.views.adapters.RepoListAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GitHubSearchFragment extends Fragment implements GithubDataManager.SearchReposCallback {

    private ImageButton searchButton;
    private EditText searchText;
    private RecyclerView repoRecyclerView;
    private RepoListAdapter repoListAdapter;
    private RecyclerView.LayoutManager repoListLayoutManager;
    private SearchFragmentManager searchFragmentManager;

    public GitHubSearchFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        searchFragmentManager = (SearchFragmentManager) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_git_hub_search, container, false);
        // Inflate the layout for this fragment
        Spinner spinner = (Spinner) view.findViewById(R.id.filter_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        searchText = (EditText) view.findViewById(R.id.search_text);
        searchButton = (ImageButton) view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new SearchClickedListener());

        repoRecyclerView = (RecyclerView) view.findViewById(R.id.repos_recycler_view);
        repoRecyclerView.setHasFixedSize(true);

        repoListLayoutManager = new LinearLayoutManager(this.getActivity());
        repoRecyclerView.setLayoutManager(repoListLayoutManager);

        return view;
    }


    public static GitHubSearchFragment newInstance(){
        return new GitHubSearchFragment();
    }

    private class SearchClickedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String searchString = searchText.getText().toString();
            GithubDataManager.getInstance().searchRepos(searchString, GitHubSearchFragment.this);
        }
    }

    @Override
    public void onResult(ArrayList<Repo> result) {
        repoListAdapter = new RepoListAdapter(result, this.getActivity(), searchFragmentManager);
        repoRecyclerView.setAdapter(repoListAdapter);
    }


    public interface SearchFragmentManager{
        public void navigateTo(Repo repo);
    }
}
