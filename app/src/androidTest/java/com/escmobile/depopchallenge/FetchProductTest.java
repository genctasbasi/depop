package com.escmobile.depopchallenge;

import android.test.InstrumentationTestCase;

import com.escmobile.depopchallenge.fetcher.FetchProductListener;
import com.escmobile.depopchallenge.fetcher.ProductFetcher;
import com.escmobile.depopchallenge.model.Product;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import retrofit.RetrofitError;

/**
 * Created by genctasbasi on 15/04/15.
 */
@RunWith(RobolectricTestRunner.class)
public class FetchProductTest extends InstrumentationTestCase {

    ProductFetcher sut = new ProductFetcher();

    @Test
    public void ProductsFetched() {
        sut.setListener(new FetchProductListener() {
            @Override
            public void onProductFetched(Product product) {
                Assert.assertTrue(product != null);
                Assert.assertTrue(product.getItems() != null);
                Assert.assertTrue(product.getItems().size() > 0);
            }

            @Override
            public void onProductFetchFailed(RetrofitError error) {
                Assert.fail("RetrofitError");
            }
        });
    }
}
