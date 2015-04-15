package com.escmobile.depopchallenge.fetcher;

import com.escmobile.depopchallenge.model.Product;
import com.escmobile.depopchallenge.model.data.User;
import com.escmobile.depopchallenge.net.APIClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by genctasbasi on 14/04/15.
 *
 * Fetcher class for Product - This is the class responsible with fetching the product(s)
 */
public class ProductFetcher implements Callback<Product>{

    APIClient apiClient;
    private FetchProductListener listener;

    public ProductFetcher(){
        apiClient = APIClient.getInstance();
    }

    public void getProduct(){
        apiClient.getProductClient().getProductList(this);
    }

    @Override
    public void success(Product product, Response response) {
        if(listener != null){
            listener.onProductFetched(product);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if(listener != null){
            listener.onProductFetchFailed(error);
        }
    }

    public void setListener(FetchProductListener listener) {
        this.listener = listener;
    }
}
