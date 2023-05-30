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
        width = MathUtils.random(100, 200);
        height = width * 2;
        reborn();
    }

    void reborn() {
        v = MathUtils.random(2f, 4f);
        a = MathUtils.random(0f, 360f);
        float k = MathUtils.random(0.5f, 10);
        radius = (float) Math.sqrt(Math.pow(SCR_WIDTH*k, 2) + Math.pow(SCR_HEIGHT*k, 2));
        x = radius * MathUtils.sin(a*MathUtils.degreesToRadians) + SCR_WIDTH/2;
        y = radius * MathUtils.cos(a*MathUtils.degreesToRadians) + SCR_HEIGHT/2;
        vx = -MathUtils.sin(a*MathUtils.degreesToRadians)*v;
        vy = -MathUtils.cos(a*MathUtils.degreesToRadians)*v;
    }

    void move() {
        if(isAlive) {
            x += vx;
            y += vy;
            if (x == SCR_WIDTH / 2) {
                vx = 0;
                x = SCR_WIDTH / 2;
            }
            if (y == SCR_HEIGHT / 2) {
                vy = 0;
                y = SCR_HEIGHT / 2;
            }
        }
    }

    boolean win() {
        return Math.abs(x-SCR_WIDTH/2) < width/2 && Math.abs(y-SCR_HEIGHT/2) < height/2;
    }

    public float getX() {
        return x-width/2;
    }

    public float getY() {
        return y-height/2;
    }

    boolean hit(float tx, float ty){
        if(x-width/2 < tx && tx < x+width/2 && y-height/2 < ty && ty < y+height/2){
            isAlive = false;
            vx = 0;
            vy = 0;
            return true;
        }
        return false;
    }
}
