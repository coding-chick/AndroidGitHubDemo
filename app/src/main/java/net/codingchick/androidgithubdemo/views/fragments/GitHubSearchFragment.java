package net.codingchick.androidgithubdemo.views.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.core.GithubDataManager;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.views.adapters.RepoListAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GitHubSearchFragment extends Fragment implements GithubDataManager.SearchReposCallback {

    @InjectView(R.id.filter_language) Spinner spinner;
    @InjectView(R.id.search_button) ImageButton searchButton;
    @InjectView(R.id.search_text) EditText searchText;
    @InjectView(R.id.repos_recycler_view) RecyclerView repoRecyclerView;

    RepoListAdapter repoListAdapter;
    RecyclerView.LayoutManager repoListLayoutManager;
    SearchFragmentManager searchFragmentManager;

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

        ButterKnife.inject(this, view);

        spinner = (Spinner) view.findViewById(R.id.filter_language);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        searchText.setOnEditorActionListener(new SearchOnEditorActionListener());
        searchText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });

        repoRecyclerView.setHasFixedSize(true);

        repoListLayoutManager = new LinearLayoutManager(this.getActivity());
        repoRecyclerView.setLayoutManager(repoListLayoutManager);

        onViewStateRestored(savedInstanceState);

        getActivity().getActionBar().show();
        return view;
    }

    @OnClick(R.id.search_button)
    public void onClick(View v) {
        hideKeyboard();
        searchRepos();
    }

    public static GitHubSearchFragment newInstance(){
        return new GitHubSearchFragment();
    }

    private class SearchClickedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            searchRepos();
        }
    }

    public void searchRepos() {
        if (searchText.getText() != null && !searchText.getText().toString().isEmpty()){
            String searchString = searchText.getText().toString();
            String languageString = null;
            if (spinner.getSelectedItem() != spinner.getItemAtPosition(0)){
                languageString = spinner.getSelectedItem().toString();
                //searchString += "+language:" + spinner.getSelectedItem();
            }

            GithubDataManager.getInstance().searchRepos(searchString, languageString, GitHubSearchFragment.this);
        }
        else {
            Toast.makeText(this.getActivity(), "Please enter search query", Toast.LENGTH_SHORT).show();
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

    public void hideKeyboard(){
        InputMethodManager imm =
                (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }

    public void showKeyboard(){
        InputMethodManager imm =
                (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchText, InputMethodManager.SHOW_IMPLICIT);
    }

    private class SearchOnEditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled = false;
            InputMethodManager imm =
                    (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                searchRepos();
                hideKeyboard();
                handled = true;
            }
            else{
                showKeyboard();
            }
            return handled;
        }
    }

//    private final static String STATE_SEARCH_TERM = "term";
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putString(STATE_SEARCH_TERM, searchText.getText() != null ? searchText.getText().toString() : null);
//
//        super.onSaveInstanceState(outState);
//    }

//    @Override
//    public void onViewStateRestored(Bundle savedInstanceState) {
//        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_SEARCH_TERM))
//            searchText.setText(savedInstanceState.getString(STATE_SEARCH_TERM));
//
//        super.onViewStateRestored(savedInstanceState);
//    }
}
