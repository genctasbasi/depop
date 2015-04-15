package com.escmobile.depopchallenge;

import android.test.InstrumentationTestCase;

import com.escmobile.depopchallenge.fetcher.FetchUserListener;
import com.escmobile.depopchallenge.fetcher.UserFetcher;
import com.escmobile.depopchallenge.model.data.User;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import retrofit.RetrofitError;

/**
 * Created by genctasbasi on 15/04/15.
 */
@RunWith(RobolectricTestRunner.class)
public class FetchUserTest extends InstrumentationTestCase {

    UserFetcher sut = new UserFetcher();

    @Test
    public void UsersFetched() {
        sut.setListener(new FetchUserListener() {

            @Override
            public void onUserFetched(User user) {
                Assert.assertTrue(user != null);
            }

            @Override
            public void onUserFetchFailed(RetrofitError error) {
                Assert.fail("RetrofitError");
            }
        });
    }

    @Test
    public void UsersHasImage() {
        sut.setListener(new FetchUserListener() {

            @Override
            public void onUserFetched(User user) {
                Assert.assertTrue(user != null);
                Assert.assertTrue(user.getImageUrl() != null);
            }

            @Override
            public void onUserFetchFailed(RetrofitError error) {
                Assert.fail("RetrofitError");
            }
        });
    }
}
