package com.escmobile.depopchallenge.model;

/**
 * Created by genctasbasi on 14/04/15.
 * This Profile object is consumed by Profile fragment to display profile info such as
 * - Name, surname
 * - Number of followers & followings
 * - Description
 *
 * TODO: Normally these models should be backed by a persistent data structure ie SQLite
 * but for the sake of the simplicity, we aren't persisting anything
 */
public class Profile {

    private String userId;
    private String userNameFull;
    private int followers;
    private int following;
    private String description;
    private String url;
    private int reviews;
    private int reviewBitmapResourceId;

    public int getFollowing() {
        return following;
    }

    public int getFollowers() {
        return followers;
    }

    public String getUserNameFull() {
        return userNameFull;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUserId() {
        return userId;
    }

    public int getReviews() {
        return reviews;
    }

    public int getReviewBitmapResourceId() {
        return reviewBitmapResourceId;
    }

    public void setReviewBitmapResourceId(int reviewBitmapResourceId) {
        this.reviewBitmapResourceId = reviewBitmapResourceId;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserNameFull(String userNameFull) {
        this.userNameFull = userNameFull;
    }
}
