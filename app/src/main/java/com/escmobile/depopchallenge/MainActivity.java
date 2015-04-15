package com.escmobile.depopchallenge;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.escmobile.depopchallenge.fetcher.FetchProductListener;
import com.escmobile.depopchallenge.fetcher.FetchUserListener;
import com.escmobile.depopchallenge.fetcher.ProductFetcher;
import com.escmobile.depopchallenge.fetcher.UserFetcher;
import com.escmobile.depopchallenge.fragment.ProfileFragment;
import com.escmobile.depopchallenge.model.Product;
import com.escmobile.depopchallenge.model.Profile;
import com.escmobile.depopchallenge.model.data.User;

import retrofit.RetrofitError;

public class MainActivity extends ActionBarActivity
        implements FetchUserListener, FetchProductListener {

    ProgressBar progressBar;
    Profile profile;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        startProgressBar();

        // TODO: Move these to a controller and get data through it
        fetchUser();
        fetchProduct();

        profileFragment = new ProfileFragment();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, profileFragment)
                    .commit();
        }
    }

    private void fetchProduct() {
        ProductFetcher productFetcher = new ProductFetcher();
        productFetcher.setListener(this);
        productFetcher.getProduct();
    }

    private void initialize() {
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        profile = new Profile();
    }

    /**
     * TODO: Normally we could add another layer here where the activity UI would call a controller, which in turn
     * calls the fetchers and marshalls the data back. **** we also may need to think better about synchronization of several calls
     * user, product and the images
     */
    private void fetchUser() {
        UserFetcher userFetcher = new UserFetcher();
        userFetcher.setListener(this);
        userFetcher.getUser();
    }

    public void startProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void stopProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onUserFetched(User user) {

        stopProgressBar();

        if (profileFragment != null) {
            profileFragment.setUser(user);
            this.setTitle("@".concat(user.getUserName()));
        }
    }

    @Override
    public void onUserFetchFailed(RetrofitError error) {
        // TODO: Handle failure
        stopProgressBar();
    }

    @Override
    public void onProductFetched(Product product) {
        if (profileFragment != null) {
            profileFragment.setProduct(product);
        }
    }

    @Override
    public void onProductFetchFailed(RetrofitError error) {
        // TODO: Handle failure
    }
}
