package net.codingchick.androidgithubdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;
import java.util.List;

public class Repo extends SugarRecord<Repo> implements Parcelable
{
    public long getRepoId() { return repoId; }

    public void setRepoId(long repoId) { this.repoId = repoId; }

    @Unique
    private long repoId;

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String full_name;

    public String getFullName() { return this.full_name; }

    public void setFullName(String full_name) { this.full_name = full_name; }

    private Owner owner;

    public Owner getOwner() { return this.owner; }

    public void setOwner(Owner owner) { this.owner = owner; }

    private boolean isPrivate;

    public boolean getPrivate() { return this.isPrivate; }

    public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }

    private String html_url;

    public String getHtmlUrl() { return this.html_url; }

    public void setHtmlUrl(String html_url) { this.html_url = html_url; }

    private String description;

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    private boolean fork;

    public boolean getFork() { return this.fork; }

    public void setFork(boolean fork) { this.fork = fork; }

    private String url;

    public String getUrl() { return this.url; }

    public void setUrl(String url) { this.url = url; }

    private String forks_url;

    public String getForksUrl() { return this.forks_url; }

    public void setForksUrl(String forks_url) { this.forks_url = forks_url; }

    private String keys_url;

    public String getKeysUrl() { return this.keys_url; }

    public void setKeysUrl(String keys_url) { this.keys_url = keys_url; }

    private String collaborators_url;

    public String getCollaboratorsUrl() { return this.collaborators_url; }

    public void setCollaboratorsUrl(String collaborators_url) { this.collaborators_url = collaborators_url; }

    private String teams_url;

    public String getTeamsUrl() { return this.teams_url; }

    public void setTeamsUrl(String teams_url) { this.teams_url = teams_url; }

    private String hooks_url;

    public String getHooksUrl() { return this.hooks_url; }

    public void setHooksUrl(String hooks_url) { this.hooks_url = hooks_url; }

    private String issue_events_url;

    public String getIssueEventsUrl() { return this.issue_events_url; }

    public void setIssueEventsUrl(String issue_events_url) { this.issue_events_url = issue_events_url; }

    private String events_url;

    public String getEventsUrl() { return this.events_url; }

    public void setEventsUrl(String events_url) { this.events_url = events_url; }

    private String assignees_url;

    public String getAssigneesUrl() { return this.assignees_url; }

    public void setAssigneesUrl(String assignees_url) { this.assignees_url = assignees_url; }

    private String branches_url;

    public String getBranchesUrl() { return this.branches_url; }

    public void setBranchesUrl(String branches_url) { this.branches_url = branches_url; }

    private String tags_url;

    public String getTagsUrl() { return this.tags_url; }

    public void setTagsUrl(String tags_url) { this.tags_url = tags_url; }

    private String blobs_url;

    public String getBlobsUrl() { return this.blobs_url; }

    public void setBlobsUrl(String blobs_url) { this.blobs_url = blobs_url; }

    private String git_tags_url;

    public String getGitTagsUrl() { return this.git_tags_url; }

    public void setGitTagsUrl(String git_tags_url) { this.git_tags_url = git_tags_url; }

    private String git_refs_url;

    public String getGitRefsUrl() { return this.git_refs_url; }

    public void setGitRefsUrl(String git_refs_url) { this.git_refs_url = git_refs_url; }

    private String trees_url;

    public String getTreesUrl() { return this.trees_url; }

    public void setTreesUrl(String trees_url) { this.trees_url = trees_url; }

    private String statuses_url;

    public String getStatusesUrl() { return this.statuses_url; }

    public void setStatusesUrl(String statuses_url) { this.statuses_url = statuses_url; }

    private String languages_url;

    public String getLanguagesUrl() { return this.languages_url; }

    public void setLanguagesUrl(String languages_url) { this.languages_url = languages_url; }

    private String stargazers_url;

    public String getStargazersUrl() { return this.stargazers_url; }

    public void setStargazersUrl(String stargazers_url) { this.stargazers_url = stargazers_url; }

    private String contributors_url;

    public String getContributorsUrl() { return this.contributors_url; }

    public void setContributorsUrl(String contributors_url) { this.contributors_url = contributors_url; }

    private String subscribers_url;

    public String getSubscribersUrl() { return this.subscribers_url; }

    public void setSubscribersUrl(String subscribers_url) { this.subscribers_url = subscribers_url; }

    private String subscription_url;

    public String getSubscriptionUrl() { return this.subscription_url; }

    public void setSubscriptionUrl(String subscription_url) { this.subscription_url = subscription_url; }

    private String commits_url;

    public String getCommitsUrl() { return this.commits_url; }

    public void setCommitsUrl(String commits_url) { this.commits_url = commits_url; }

    private String git_commits_url;

    public String getGitCommitsUrl() { return this.git_commits_url; }

    public void setGitCommitsUrl(String git_commits_url) { this.git_commits_url = git_commits_url; }

    private String comments_url;

    public String getCommentsUrl() { return this.comments_url; }

    public void setCommentsUrl(String comments_url) { this.comments_url = comments_url; }

    private String issue_comment_url;

    public String getIssueCommentUrl() { return this.issue_comment_url; }

    public void setIssueCommentUrl(String issue_comment_url) { this.issue_comment_url = issue_comment_url; }

    private String contents_url;

    public String getContentsUrl() { return this.contents_url; }

    public void setContentsUrl(String contents_url) { this.contents_url = contents_url; }

    private String compare_url;

    public String getCompareUrl() { return this.compare_url; }

    public void setCompareUrl(String compare_url) { this.compare_url = compare_url; }

    private String merges_url;

    public String getMergesUrl() { return this.merges_url; }

    public void setMergesUrl(String merges_url) { this.merges_url = merges_url; }

    private String archive_url;

    public String getArchiveUrl() { return this.archive_url; }

    public void setArchiveUrl(String archive_url) { this.archive_url = archive_url; }

    private String downloads_url;

    public String getDownloadsUrl() { return this.downloads_url; }

    public void setDownloadsUrl(String downloads_url) { this.downloads_url = downloads_url; }

    private String issues_url;

    public String getIssuesUrl() { return this.issues_url; }

    public void setIssuesUrl(String issues_url) { this.issues_url = issues_url; }

    private String pulls_url;

    public String getPullsUrl() { return this.pulls_url; }

    public void setPullsUrl(String pulls_url) { this.pulls_url = pulls_url; }

    private String milestones_url;

    public String getMilestonesUrl() { return this.milestones_url; }

    public void setMilestonesUrl(String milestones_url) { this.milestones_url = milestones_url; }

    private String notifications_url;

    public String getNotificationsUrl() { return this.notifications_url; }

    public void setNotificationsUrl(String notifications_url) { this.notifications_url = notifications_url; }

    private String labels_url;

    public String getLabelsUrl() { return this.labels_url; }

    public void setLabelsUrl(String labels_url) { this.labels_url = labels_url; }

    private String releases_url;

    public String getReleasesUrl() { return this.releases_url; }

    public void setReleasesUrl(String releases_url) { this.releases_url = releases_url; }

    private Date created_at;

    public Date getCreatedAt() { return this.created_at; }

    public void setCreatedAt(Date created_at) { this.created_at = created_at; }

    private Date updated_at;

    public Date getUpdatedAt() { return this.updated_at; }

    public void setUpdatedAt(Date updated_at) { this.updated_at = updated_at; }

    private Date pushed_at;

    public Date getPushedAt() { return this.pushed_at; }

    public void setPushedAt(Date pushed_at) { this.pushed_at = pushed_at; }

    private String git_url;

    public String getGitUrl() { return this.git_url; }

    public void setGitUrl(String git_url) { this.git_url = git_url; }

    private String ssh_url;

    public String getSshUrl() { return this.ssh_url; }

    public void setSshUrl(String ssh_url) { this.ssh_url = ssh_url; }

    private String clone_url;

    public String getCloneUrl() { return this.clone_url; }

    public void setCloneUrl(String clone_url) { this.clone_url = clone_url; }

    private String svn_url;

    public String getSvnUrl() { return this.svn_url; }

    public void setSvnUrl(String svn_url) { this.svn_url = svn_url; }

    private String homepage;

    public String getHomepage() { return this.homepage; }

    public void setHomepage(String homepage) { this.homepage = homepage; }

    private int size;

    public int getSize() { return this.size; }

    public void setSize(int size) { this.size = size; }

    private int stargazers_count;

    public int getStargazersCount() { return this.stargazers_count; }

    public void setStargazersCount(int stargazers_count) { this.stargazers_count = stargazers_count; }

    private int watchers_count;

    public int getWatchersCount() { return this.watchers_count; }

    public void setWatchersCount(int watchers_count) { this.watchers_count = watchers_count; }

    private String language;

    public String getLanguage() { return this.language; }

    public void setLanguage(String language) { this.language = language; }

    private boolean has_issues;

    public boolean getHasIssues() { return this.has_issues; }

    public void setHasIssues(boolean has_issues) { this.has_issues = has_issues; }

    private boolean has_downloads;

    public boolean getHasDownloads() { return this.has_downloads; }

    public void setHasDownloads(boolean has_downloads) { this.has_downloads = has_downloads; }

    private boolean has_wiki;

    public boolean getHasWiki() { return this.has_wiki; }

    public void setHasWiki(boolean has_wiki) { this.has_wiki = has_wiki; }

    private boolean has_pages;

    public boolean getHasPages() { return this.has_pages; }

    public void setHasPages(boolean has_pages) { this.has_pages = has_pages; }

    private int forks_count;

    public int getForksCount() { return this.forks_count; }

    public void setForksCount(int forks_count) { this.forks_count = forks_count; }

    private int open_issues_count;

    public int getOpenIssuesCount() { return this.open_issues_count; }

    public void setOpenIssuesCount(int open_issues_count) { this.open_issues_count = open_issues_count; }

    private int forks;

    public int getForks() { return this.forks; }

    public void setForks(int forks) { this.forks = forks; }

    private int open_issues;

    public int getOpenIssues() { return this.open_issues; }

    public void setOpenIssues(int open_issues) { this.open_issues = open_issues; }

    private int watchers;

    public int getWatchers() { return this.watchers; }

    public void setWatchers(int watchers) { this.watchers = watchers; }

    private String default_branch;

    public String getDefaultBranch() { return this.default_branch; }

    public void setDefaultBranch(String default_branch) { this.default_branch = default_branch; }

    private double score;

    public double getScore() { return this.score; }

    public void setScore(double score) { this.score = score; }

    public Repo() {
        created_at = new Date();
        updated_at = new Date();
        pushed_at = new Date();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.full_name);
        dest.writeParcelable(this.owner, flags);
        dest.writeByte(isPrivate ? (byte) 1 : (byte) 0);
        dest.writeString(this.html_url);
        dest.writeString(this.description);
        dest.writeByte(fork ? (byte) 1 : (byte) 0);
        dest.writeString(this.url);
        dest.writeString(this.forks_url);
        dest.writeString(this.keys_url);
        dest.writeString(this.collaborators_url);
        dest.writeString(this.teams_url);
        dest.writeString(this.hooks_url);
        dest.writeString(this.issue_events_url);
        dest.writeString(this.events_url);
        dest.writeString(this.assignees_url);
        dest.writeString(this.branches_url);
        dest.writeString(this.tags_url);
        dest.writeString(this.blobs_url);
        dest.writeString(this.git_tags_url);
        dest.writeString(this.git_refs_url);
        dest.writeString(this.trees_url);
        dest.writeString(this.statuses_url);
        dest.writeString(this.languages_url);
        dest.writeString(this.stargazers_url);
        dest.writeString(this.contributors_url);
        dest.writeString(this.subscribers_url);
        dest.writeString(this.subscription_url);
        dest.writeString(this.commits_url);
        dest.writeString(this.git_commits_url);
        dest.writeString(this.comments_url);
        dest.writeString(this.issue_comment_url);
        dest.writeString(this.contents_url);
        dest.writeString(this.compare_url);
        dest.writeString(this.merges_url);
        dest.writeString(this.archive_url);
        dest.writeString(this.downloads_url);
        dest.writeString(this.issues_url);
        dest.writeString(this.pulls_url);
        dest.writeString(this.milestones_url);
        dest.writeString(this.notifications_url);
        dest.writeString(this.labels_url);
        dest.writeString(this.releases_url);
        dest.writeLong(created_at != null ? created_at.getTime() : -1);
        dest.writeLong(updated_at != null ? updated_at.getTime() : -1);
        dest.writeLong(pushed_at != null ? pushed_at.getTime() : -1);
        dest.writeString(this.git_url);
        dest.writeString(this.ssh_url);
        dest.writeString(this.clone_url);
        dest.writeString(this.svn_url);
        dest.writeString(this.homepage);
        dest.writeInt(this.size);
        dest.writeInt(this.stargazers_count);
        dest.writeInt(this.watchers_count);
        dest.writeString(this.language);
        dest.writeByte(has_issues ? (byte) 1 : (byte) 0);
        dest.writeByte(has_downloads ? (byte) 1 : (byte) 0);
        dest.writeByte(has_wiki ? (byte) 1 : (byte) 0);
        dest.writeByte(has_pages ? (byte) 1 : (byte) 0);
        dest.writeInt(this.forks_count);
        dest.writeInt(this.open_issues_count);
        dest.writeInt(this.forks);
        dest.writeInt(this.open_issues);
        dest.writeInt(this.watchers);
        dest.writeString(this.default_branch);
        dest.writeDouble(this.score);
    }



    private Repo(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.full_name = in.readString();
        this.owner = in.readParcelable(Owner.class.getClassLoader());
        this.isPrivate = in.readByte() != 0;
        this.html_url = in.readString();
        this.description = in.readString();
        this.fork = in.readByte() != 0;
        this.url = in.readString();
        this.forks_url = in.readString();
        this.keys_url = in.readString();
        this.collaborators_url = in.readString();
        this.teams_url = in.readString();
        this.hooks_url = in.readString();
        this.issue_events_url = in.readString();
        this.events_url = in.readString();
        this.assignees_url = in.readString();
        this.branches_url = in.readString();
        this.tags_url = in.readString();
        this.blobs_url = in.readString();
        this.git_tags_url = in.readString();
        this.git_refs_url = in.readString();
        this.trees_url = in.readString();
        this.statuses_url = in.readString();
        this.languages_url = in.readString();
        this.stargazers_url = in.readString();
        this.contributors_url = in.readString();
        this.subscribers_url = in.readString();
        this.subscription_url = in.readString();
        this.commits_url = in.readString();
        this.git_commits_url = in.readString();
        this.comments_url = in.readString();
        this.issue_comment_url = in.readString();
        this.contents_url = in.readString();
        this.compare_url = in.readString();
        this.merges_url = in.readString();
        this.archive_url = in.readString();
        this.downloads_url = in.readString();
        this.issues_url = in.readString();
        this.pulls_url = in.readString();
        this.milestones_url = in.readString();
        this.notifications_url = in.readString();
        this.labels_url = in.readString();
        this.releases_url = in.readString();
        long tmpCreated_at = in.readLong();
        this.created_at = tmpCreated_at == -1 ? null : new Date(tmpCreated_at);
        long tmpUpdated_at = in.readLong();
        this.updated_at = tmpUpdated_at == -1 ? null : new Date(tmpUpdated_at);
        long tmpPushed_at = in.readLong();
        this.pushed_at = tmpPushed_at == -1 ? null : new Date(tmpPushed_at);
        this.git_url = in.readString();
        this.ssh_url = in.readString();
        this.clone_url = in.readString();
        this.svn_url = in.readString();
        this.homepage = in.readString();
        this.size = in.readInt();
        this.stargazers_count = in.readInt();
        this.watchers_count = in.readInt();
        this.language = in.readString();
        this.has_issues = in.readByte() != 0;
        this.has_downloads = in.readByte() != 0;
        this.has_wiki = in.readByte() != 0;
        this.has_pages = in.readByte() != 0;
        this.forks_count = in.readInt();
        this.open_issues_count = in.readInt();
        this.forks = in.readInt();
        this.open_issues = in.readInt();
        this.watchers = in.readInt();
        this.default_branch = in.readString();
        this.score = in.readDouble();
    }

    public static final Creator<Repo> CREATOR = new Creator<Repo>() {
        public Repo createFromParcel(Parcel source) {
            return new Repo(source);
        }

        public Repo[] newArray(int size) {
            return new Repo[size];
        }
    };
}
