package net.codingchick.androidgithubdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Efrat Barak on 4/19/2015.
 */
public class Owner implements Parcelable {
    private String login;

    public String getLogin() { return this.login; }

    public void setLogin(String login) { this.login = login; }

    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String avatar_url;

    public String getAvatarUrl() { return this.avatar_url; }

    public void setAvatarUrl(String avatar_url) { this.avatar_url = avatar_url; }

    private String gravatar_id;

    public String getGravatarId() { return this.gravatar_id; }

    public void setGravatarId(String gravatar_id) { this.gravatar_id = gravatar_id; }

    private String url;

    public String getUrl() { return this.url; }

    public void setUrl(String url) { this.url = url; }

    private String html_url;

    public String getHtmlUrl() { return this.html_url; }

    public void setHtmlUrl(String html_url) { this.html_url = html_url; }

    private String followers_url;

    public String getFollowersUrl() { return this.followers_url; }

    public void setFollowersUrl(String followers_url) { this.followers_url = followers_url; }

    private String following_url;

    public String getFollowingUrl() { return this.following_url; }

    public void setFollowingUrl(String following_url) { this.following_url = following_url; }

    private String gists_url;

    public String getGistsUrl() { return this.gists_url; }

    public void setGistsUrl(String gists_url) { this.gists_url = gists_url; }

    private String starred_url;

    public String getStarredUrl() { return this.starred_url; }

    public void setStarredUrl(String starred_url) { this.starred_url = starred_url; }

    private String subscriptions_url;

    public String getSubscriptionsUrl() { return this.subscriptions_url; }

    public void setSubscriptionsUrl(String subscriptions_url) { this.subscriptions_url = subscriptions_url; }

    private String organizations_url;

    public String getOrganizationsUrl() { return this.organizations_url; }

    public void setOrganizationsUrl(String organizations_url) { this.organizations_url = organizations_url; }

    private String repos_url;

    public String getReposUrl() { return this.repos_url; }

    public void setReposUrl(String repos_url) { this.repos_url = repos_url; }

    private String events_url;

    public String getEventsUrl() { return this.events_url; }

    public void setEventsUrl(String events_url) { this.events_url = events_url; }

    private String received_events_url;

    public String getReceivedEventsUrl() { return this.received_events_url; }

    public void setReceivedEventsUrl(String received_events_url) { this.received_events_url = received_events_url; }

    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private boolean site_admin;

    public boolean getSiteAdmin() { return this.site_admin; }

    public void setSiteAdmin(boolean site_admin) { this.site_admin = site_admin; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeInt(this.id);
        dest.writeString(this.avatar_url);
        dest.writeString(this.gravatar_id);
        dest.writeString(this.url);
        dest.writeString(this.html_url);
        dest.writeString(this.followers_url);
        dest.writeString(this.following_url);
        dest.writeString(this.gists_url);
        dest.writeString(this.starred_url);
        dest.writeString(this.subscriptions_url);
        dest.writeString(this.organizations_url);
        dest.writeString(this.repos_url);
        dest.writeString(this.events_url);
        dest.writeString(this.received_events_url);
        dest.writeString(this.type);
        dest.writeByte(site_admin ? (byte) 1 : (byte) 0);
    }

    public Owner() {
    }

    private Owner(Parcel in) {
        this.login = in.readString();
        this.id = in.readInt();
        this.avatar_url = in.readString();
        this.gravatar_id = in.readString();
        this.url = in.readString();
        this.html_url = in.readString();
        this.followers_url = in.readString();
        this.following_url = in.readString();
        this.gists_url = in.readString();
        this.starred_url = in.readString();
        this.subscriptions_url = in.readString();
        this.organizations_url = in.readString();
        this.repos_url = in.readString();
        this.events_url = in.readString();
        this.received_events_url = in.readString();
        this.type = in.readString();
        this.site_admin = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Owner> CREATOR = new Parcelable.Creator<Owner>() {
        public Owner createFromParcel(Parcel source) {
            return new Owner(source);
        }

        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };
}
