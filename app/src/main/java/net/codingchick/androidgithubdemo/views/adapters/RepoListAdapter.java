package net.codingchick.androidgithubdemo.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.codingchick.androidgithubdemo.R;
import net.codingchick.androidgithubdemo.model.Repo;
import net.codingchick.androidgithubdemo.views.fragments.GitHubSearchFragment;

import java.util.ArrayList;

/**
 * Created by Efrat Barak on 4/19/2015.
 */
public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<Repo> reposDataSet;
    private Context context;
    private GitHubSearchFragment.SearchFragmentManager searchFragmentManager;

    public RepoListAdapter(ArrayList<Repo> reposDataSet, Context context, GitHubSearchFragment.SearchFragmentManager searchFragmentManager){

        this.reposDataSet = reposDataSet;
        this.context = context;
        this.searchFragmentManager = searchFragmentManager;
    }

    @Override
    public RepoListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RelativeLayout currentView = (RelativeLayout) LayoutInflater.from(context)
                .inflate(R.layout.repo_in_list, viewGroup, false);
        currentView.setOnClickListener(this);

        return new ViewHolder(currentView);

    }

    @Override
    public void onBindViewHolder(RepoListAdapter.ViewHolder viewHolder, int i) {
        Repo currentRepo = reposDataSet.get(i);
        viewHolder.itemView.setTag(currentRepo);
        viewHolder.repoNameText.setText(currentRepo.getName());

    }

    @Override
    public int getItemCount() {
        return reposDataSet.toArray().length;
    }

    @Override
    public void onClick(View v) {
        Repo currentRepo = (Repo) v.getTag();
        searchFragmentManager.navigateTo(currentRepo);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView repoNameText;
        public ViewHolder(RelativeLayout view) {
            super(view);
            this.repoNameText = (TextView) view.findViewById(R.id.repo_name_text);
        }
    }

}
