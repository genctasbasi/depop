package com.escmobile.depopchallenge.model.data;

import java.util.List;

/**
 * Created by genctasbasi on 14/04/15.
 */
public class User {

    private String id;
    private String first_name;
    private String last_name;
    private String followers_count;
    private String following_count;
    private String website;
    private String bio;
    private String username;
    private PictureData picture_data;

    public String getId(){
        return id;
    }

    public String getFirstName(){
        return first_name;
    }

    public String getLastName(){
        return last_name;
    }

    public String getFollowersCount() {
        return followers_count;
    }

    public String getFollowingCount() {
        return following_count;
    }

    public String getWebsite() {
        return website;
    }

    public String getBio() {
        return bio;
    }

    public String getUserName() {
        return username;
    }

    public String getImageUrl(){
        if(picture_data != null){
            Format format = picture_data.formats;

            if(format != null && format.getSize() != null){
                return format.getSize().url;
            }
        }

        return null;
    }

    private class PictureData{
        private Format formats;

        public Format getFormat() {
            return formats;
        }
    }

    class Format{
        private FormatSize U0;

        public FormatSize getSize() {
            return U0;
        }
    }

    class FormatSize {
        private String url;

        public String getUrl() {
            return url;
        }
    }
}
