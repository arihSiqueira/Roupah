package com.example.arihanemariano.roupah.model;

/**
 * Created by Arihane.Mariano on 24/11/2015.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;

    public NavDrawerItem(){}
    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShowNotify() {

        return showNotify;
    }

    public String getTitle() {
        return title;
    }
}
