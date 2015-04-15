package com.escmobile.depopchallenge.net;

import com.escmobile.depopchallenge.config.Config;
import com.escmobile.depopchallenge.net.contracts.Product;
import com.escmobile.depopchallenge.net.contracts.User;

import retrofit.RestAdapter;

/**
 * Created by genctasbasi on 14/04/15.
 */
public class APIClient {

    private static APIClient apiClient;

    public static APIClient getInstance(){
        if(apiClient == null){
            apiClient = new APIClient();
        }

        return apiClient;
    }

    private APIClient(){}

    public User getUserClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Config.API_BASE_URL)
                .build();

        return restAdapter.create(User.class);
    }

    public Product getProductClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Config.API_BASE_URL)
                .build();

        return restAdapter.create(Product.class);
    }
}
