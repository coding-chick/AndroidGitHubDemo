package net.codingchick.androidgithubdemo.core;

import android.content.Context;

import com.orm.SugarApp;

/**
 * Created by Efrat Barak on 4/22/2015.
 */
public class AndroidGitHubDemoApplication extends SugarApp {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        AndroidGitHubDemoApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return AndroidGitHubDemoApplication.context;
    }

}
