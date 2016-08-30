package com.example.homin.p4.rest;

/**
 * Created by HOMIN on 2016-08-30.
 */
public class RestPojo {

    String title;
    String author;
    String subreddit;
    String thumbnail;

    int points;
    int comments;

    public RestPojo(String title, String author, String subreddit, int points, int comments, String thumbnail) {
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
