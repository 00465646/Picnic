package com.mygdx.game;
import static com.mygdx.game.Picnic.SCR_HEIGHT;
import static com.mygdx.game.Picnic.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Сockroach {
    float x, y;
    float vx, vy;
    float width, height;
    int faza, nFaz = 10;
    boolean isAlive = true;
    float v, a, radius;

    public Сockroach() {
        width = MathUtils.random(50, 100);
        height = width * 2;
        v = MathUtils.random(0.2f, 1f);
        a = MathUtils.random(0f, 360f);
        radius = (float) Math.sqrt(Math.pow(SCR_WIDTH, 2) + Math.pow(SCR_HEIGHT, 2));
        x = radius * MathUtils.sin(a) + SCR_WIDTH/2;
        y = radius * MathUtils.cos(a) + SCR_HEIGHT/2;
        vx = -MathUtils.sin(a)*v;
        vy = -MathUtils.cos(a)*v;
    }

    void move() {
        x += vx;
        y += vy;
        if(x == SCR_WIDTH/2) {
            vx = 0;
            x = SCR_WIDTH/2;
        }
        if(y == SCR_HEIGHT/2) {
            vy = 0;
            y = SCR_HEIGHT/2;
        }
    }

    boolean hit(float tx, float ty){
        if(x < tx && tx < x+width && y < ty && ty < y+height){
            isAlive = false;
            faza = 10;
            vx = 0;
            vy = 0;
            return true;
        }
        return false;
    }
}
