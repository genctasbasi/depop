package com.escmobile.depopchallenge.model;

import com.escmobile.depopchallenge.model.data.Item;

import java.util.List;

/**
 * Created by genctasbasi on 14/04/15.
 *
 * TODO: Normally these models should be backed by a persistent data structure ie SQLite
 * but for the sake of the simplicity, we aren't persisting anything
 *
 */
public class Product {

    private List<Item> objects;

    public List<Item> getItems() {
        return objects;
    }
}
