package com.escmobile.depopchallenge.fetcher;

import com.escmobile.depopchallenge.model.data.User;

import retrofit.RetrofitError;

/**
 * Created by genctasbasi on 14/04/15.
 */
public interface FetchUserListener {

    void onUserFetched(User user);
    void onUserFetchFailed(RetrofitError error);
}
