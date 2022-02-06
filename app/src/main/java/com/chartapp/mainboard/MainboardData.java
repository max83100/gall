package com.chartapp.mainboard;

public class MainboardData {
    private String productName;
    private String productDate;


    public MainboardData(String productName, String productDate) {
        this.productName = productName;
        this.productDate = productDate;

    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getproductDate() {
        return productDate;
    }

    public void setproductDate(String productDate) {
        this.productDate = productDate;
    }


}


