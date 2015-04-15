package com.escmobile.depopchallenge.fetcher;

import com.escmobile.depopchallenge.model.data.User;
import com.escmobile.depopchallenge.net.APIClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by genctasbasi on 14/04/15.
 *
 * Fetcher class for User - This is the class responsible with fetching the user
 */
public class UserFetcher implements Callback<User>{

    APIClient apiClient;
    private FetchUserListener listener;

    public UserFetcher(){
        apiClient = APIClient.getInstance();
    }

    /**
     * TODO: Well normally we would return a list of users here, not a single user.
     * However we have a single user in the JSON sample so we keep it like that here.
     */
    public void getUser(){
        apiClient.getUserClient().getUser(this);
    }

    @Override
    public void success(User user, Response response) {
        if(listener != null){
            listener.onUserFetched(user);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if(listener != null){
            listener.onUserFetchFailed(error);
        }
    }

    public void setListener(FetchUserListener listener) {
        this.listener = listener;
    }
}
