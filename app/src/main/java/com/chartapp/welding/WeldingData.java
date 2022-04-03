package com.chartapp.welding;

public class WeldingData {
    String Name, count;
    int imageView;

    public WeldingData() {
    }

    public WeldingData(int imageView, String Name, String count) {
        this.Name = Name;
        this.imageView = imageView;
        this.count = count;
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


