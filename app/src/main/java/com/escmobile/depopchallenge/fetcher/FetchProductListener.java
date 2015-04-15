package com.escmobile.depopchallenge.fetcher;

import com.escmobile.depopchallenge.model.Product;

import retrofit.RetrofitError;

/**
 * Created by genctasbasi on 14/04/15.
 */
public interface FetchProductListener {
    void onProductFetched(Product product);
    void onProductFetchFailed(RetrofitError error);
}
