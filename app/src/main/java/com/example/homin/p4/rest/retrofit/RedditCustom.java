package com.example.homin.p4.rest.retrofit;

/**
 * Created by HOMIN on 2016-08-30.
 */
public class RedditCustom {

    private String title;
    private String author;
    private String subreddit;
    private String thumbnail;

    private int points;
    private int comments;

    public RedditCustom(String title, String author, String subreddit, int points, int comments, String thumbnail) {
        this.title = title;
        this.author = author;
        this.subreddit = subreddit;
        this.points = points;
        this.comments = comments;
        this.thumbnail = thumbnail;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public int getPoints() {
        return points;
    }

    public int getComments() {
        return comments;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
