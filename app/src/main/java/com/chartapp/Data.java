package com.chartapp;

public class Data {


    String name;
    String ref;
    String other;

    public Data(String name, String ref, String other) {
        this.name = name;
        this.ref = ref;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public String getRef() {
        return ref;
    }

    public String getOther() {
        return other;
    }
}