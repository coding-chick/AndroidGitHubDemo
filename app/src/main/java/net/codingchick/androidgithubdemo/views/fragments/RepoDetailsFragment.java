package net.codingchick.androidgithubdemo.views.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.model.Repo;


public class RepoDetailsFragment extends Fragment {
   
    private static final String ARG_REPO = "repo";

    private Repo repo;
   
    public static RepoDetailsFragment newInstance(Repo repo) {
        RepoDetailsFragment fragment = new RepoDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_REPO, repo);
        fragment.setArguments(args);
        return fragment;
    }

    public RepoDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            repo = getArguments().getParcelable(ARG_REPO);
            Toast.makeText(this.getActivity(), repo.getName(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repo_details, container, false);
    }


}
