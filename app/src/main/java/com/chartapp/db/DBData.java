package com.chartapp.db;

public class DBData {
    String name_model;
    String reffer;

    public String getName_model() {
        return name_model;
    }

    public void setName_model(String name_model) {
        this.name_model = name_model;
    }

    public String getReffer() {
        return reffer;
    }

    public void setReffer(String reffer) {
        this.reffer = reffer;
    }

    public DBData(String name_model, String reffer) {
        this.name_model = name_model;
        this.reffer = reffer;
    }
}
