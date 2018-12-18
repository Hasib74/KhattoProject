package com.example.monu.khattoproject.Model;

public class KhattoData {
    private  String key_id;
   private String item_name;
   private String item_price;
   private String item_fav_status;

    public KhattoData() {
    }

    public KhattoData(String key_id, String item_name, String item_price, String item_fav_status) {
        this.key_id = key_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_fav_status = item_fav_status;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_fav_status() {
        return item_fav_status;
    }

    public void setItem_fav_status(String item_fav_status) {
        this.item_fav_status = item_fav_status;
    }
}
