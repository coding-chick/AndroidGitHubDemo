package net.codingchick.androidgithubdemo.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Efrat Barak on 4/22/2015.
 */
public class AppConnectivityManager {
    public static boolean isConnectedToInternet(){
//        ConnectivityManager cm = (ConnectivityManager) AndroidGitHubDemoApplication.getAppContext().getSystemService(
//                Context.CONNECTIVITY_SERVICE);


        ConnectivityManager cm = (ConnectivityManager)  AndroidGitHubDemoApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isConnected = false;
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

}
