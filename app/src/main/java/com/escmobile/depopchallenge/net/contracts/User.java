package com.escmobile.depopchallenge.net.contracts;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by genctasbasi on 14/04/15.
 */
public interface User {
    /**
     * TODO: We would normally expect to have a List<> here but since our JSON
     * returns only one user, we'll stick to one user here
     * @param callback
     */
    @GET("/users/header.json")
    void getUser(Callback<com.escmobile.depopchallenge.model.data.User> callback);
}
