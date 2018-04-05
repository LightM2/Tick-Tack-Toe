package com.svitlanamozharovska.ticktacktoe;


public enum ImageXO {

    THEME_1(R.drawable.zero,R.drawable.cross,R.color.colorWhite,R.drawable.ic_brush_black_24dp,R.color.colorBlack),
    THEME_2(R.drawable.zero1,R.drawable.cross1,R.drawable.bckgrnd3,R.drawable.ic_brush_black_24dp,R.color.colorBlack),
    THEME_3(R.drawable.zero2,R.drawable.cross2,R.drawable.bckgrnd1,R.drawable.ic_brush_black_24dp,R.color.colorBlack),
    THEME_4(R.drawable.zero3,R.drawable.cross3,R.drawable.bckgrnd2,R.drawable.ic_brush_white_48dp,R.color.colorWhite),
    THEME_5(R.drawable.zero1,R.drawable.cross1,R.drawable.bckgrnd2,R.drawable.ic_brush_white_48dp,R.color.colorWhite);

    int zero;
    int cross;
    int background;
    int brush;
    int textColor;

    ImageXO(int stylesZero, int stylesCross, int stylesBackground, int stylesBrush, int stylesTextColor){
        zero = stylesZero;
        cross = stylesCross;
        background = stylesBackground;
        brush = stylesBrush;
        textColor = stylesTextColor;
    }

    public int getZero() {
        return zero;
    }

    public int getCross() {
        return cross;
    }

    public int getBackground() {
        return background;
    }

    public int getBrush() {
        return brush;
    }

    public int getTextColor() {
        return textColor;
    }
}
