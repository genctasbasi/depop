package com.escmobile.depopchallenge.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.escmobile.depopchallenge.R;
import com.escmobile.depopchallenge.adapter.GridImageAdapter;
import com.escmobile.depopchallenge.model.Product;
import com.escmobile.depopchallenge.model.data.User;
import com.squareup.picasso.Picasso;

/**
 * Created by genctasbasi on 14/04/15.
 */
public class ProfileFragment extends Fragment {

    TextView userName;
    TextView followers;
    TextView following;
    TextView bio;
    TextView website;
    TextView reviews;

    ImageView userImage;
    ImageView reviewsImage;
    GridView gridview;

    private User user;
    private Product product;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        initialize(rootView);

        return rootView;
    }

    private void initialize(View rootView) {
        userName = (TextView) rootView.findViewById(R.id.user_name);
        followers = (TextView) rootView.findViewById(R.id.number_of_followers);
        following = (TextView) rootView.findViewById(R.id.number_of_following);
        bio = (TextView) rootView.findViewById(R.id.bio);
        website = (TextView) rootView.findViewById(R.id.website);
        reviews = (TextView) rootView.findViewById(R.id.number_of_reviews);

        userImage = (ImageView) rootView.findViewById(R.id.user_image);
        reviewsImage = (ImageView) rootView.findViewById(R.id.review_image);

        gridview = (GridView) rootView.findViewById(R.id.grid_view);

    }

    /**
     * TODO: Rather than setting user and product like that, it would be better if we could pass a Profile object
     * with all fields populated. I created the Profile object afterwards but didn't have time to use that approach
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
        userName.setText(user.getFirstName().concat(" ").concat(user.getLastName()));
        followers.setText(user.getFollowersCount());
        following.setText(user.getFollowingCount());
        website.setText(user.getWebsite());
        bio.setText(user.getBio());

        // TODO use callback target to handle possible failure
        Picasso.with(getActivity()).load(user.getImageUrl()).into(userImage);
    }

    public void setProduct(Product product) {
        this.product = product;
        gridview.setAdapter(new GridImageAdapter(getActivity(), product.getItems()));
    }
}