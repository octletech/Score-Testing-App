package com.esporte;

/**
 * Created by Aky on 1/7/2016.
 */
public class RowPointItem {
    private String Set;
    private String ppoint1;
    private String ppoint2;

    public RowPointItem(String set, String ppoint1, String ppoint2) {
        Set = set;
        this.ppoint1 = ppoint1;
        this.ppoint2 = ppoint2;
    }

    public String getSet() {
        return Set;
    }

    public void setSet(String set) {
        Set = set;
    }

    public String getPpoint1() {
        return ppoint1;
    }

    public void setPpoint1(String ppoint1) {
        this.ppoint1 = ppoint1;
    }

    public String getPpoint2() {
        return ppoint2;
    }

    public void setPpoint2(String ppoint2) {
        this.ppoint2 = ppoint2;
    }
}

