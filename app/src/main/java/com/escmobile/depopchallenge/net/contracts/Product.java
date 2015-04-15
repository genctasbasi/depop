package com.escmobile.depopchallenge.net.contracts;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by genctasbasi on 14/04/15.
 */
public interface Product {
    @GET("/products.json")
    void getProductList(Callback<com.escmobile.depopchallenge.model.Product> callback);
}
