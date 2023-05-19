package com.mygdx.game;

public class ImageButton {
    float x, y;
    float width, height;

    public ImageButton(float x, float y, float size){
        width = height = size;
        this.x = x;
        this.y = y;
    }

    boolean hit(float tx, float ty){
        if(x < tx && tx < x+width && y < ty && ty < y+height){
            return true;
        }
        return false;
    }
}
