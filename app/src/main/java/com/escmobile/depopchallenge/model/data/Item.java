package com.escmobile.depopchallenge.model.data;

import java.util.List;

/**
 * Created by genctasbasi on 14/04/15.
 * This is the objects node from JSON
 */
public class Item {

    private String id;
    private String description;
    private String address;
    private String price_amount;
    private String price_currency;
    private List<PictureData> pictures_data;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPriceCurrency() {
        return price_currency;
    }

    public String getPriceAmount() {
        return price_amount;
    }

    public String getAddress() {
        return address;
    }

    public String getImageUrl(){
        if(pictures_data != null
                && pictures_data.size() > 0
                && pictures_data.get(0) != null){
            Format format = pictures_data.get(0).formats;

            if(format != null && format.getFormatSize() != null){
                return format.getFormatSize().url;
            }
        }

        return null;
    }

    private class PictureData{
        private Format formats;

        public Format getFormat() {
            return formats;
        }
    }

    class Format{
        private FormatSize P0;

        // get the first format for now
        public FormatSize getFormatSize() {
            return P0;
        }
    }

    class FormatSize {
        private String url;

        public String getUrl() {
            return url;
        }
    }
}
