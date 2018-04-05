package com.svitlanamozharovska.ticktacktoe;

public class SettingsHolder {
    private static SettingsHolder instance;

    private SettingsHolder() {

    }

    public static SettingsHolder getInstance() {
        if (instance == null) {
            instance = new SettingsHolder();
        }
        return instance;
    }

    private ImageXO theme = ImageXO.THEME_1;

    public ImageXO getTheme() {
        return theme;
    }

    public void setTheme(ImageXO theme) {
        this.theme = theme;
    }
}
