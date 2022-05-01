package com.chartapp.phones;

import java.io.InputStream;

public class PhoneData {
    String Name, count;
    int imageView;

    public PhoneData() {
    }

    public PhoneData(int imageView, String Name, String count) {
        this.Name = Name;
        this.imageView = imageView;
        this.count = count;
    }


    public PhoneData(String name, String ref, String other) {
    }


    public String getName() {
        return Name;
    }

    public String getCount() {
        return count;
    }

    public int getImageView() {
        return imageView;
    }
}


