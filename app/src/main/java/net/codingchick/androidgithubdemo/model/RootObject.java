package net.codingchick.androidgithubdemo.model;


import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class RootObject extends SugarRecord<RootObject>
{
    public RootObject(){
    }

    private int total_count;

    public int getTotalCount() { return this.total_count; }

    public void setTotalCount(int total_count) { this.total_count = total_count; }

    private boolean incomplete_results;

    public boolean getIncompleteResults() { return this.incomplete_results; }

    public void setIncompleteResults(boolean incomplete_results) { this.incomplete_results = incomplete_results; }

    private ArrayList<Repo> items;

    public ArrayList<Repo> getItems() { return this.items; }

    public void setItems(ArrayList<Repo> items) { this.items = items; }
}
