package com.chartapp.laptop;

import java.io.InputStream;

public class LaptopData {
    String Name, count;
    int imageView;

    public LaptopData() {
    }

    public LaptopData(int imageView, String Name, String count) {
        this.Name = Name;
        this.imageView = imageView;
        this.count = count;
    }

    public LaptopData(InputStream open, String compal, String count) {
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


