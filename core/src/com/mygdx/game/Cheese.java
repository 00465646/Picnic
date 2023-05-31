package com.mygdx.game;
import static com.mygdx.game.Picnic.SCR_HEIGHT;
import static com.mygdx.game.Picnic.SCR_WIDTH;

public class Cheese {
    float x, y;
    float width, height;
    int live = 100;


    public Cheese() {
        width = height = 300;
        x = SCR_WIDTH/2;
        y = SCR_HEIGHT/2;
    }

    public float getX() {
        return x-width/2;
    }

    public float getY() {
        return y-height/2;
    }
}
