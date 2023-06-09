package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;


public class Picnic extends Game {
    public static final float SCR_WIDTH = 1280;
    public static final float SCR_HEIGHT = 720;
    // системные объекты
    SpriteBatch batch; // ссылка на объект, отвечающий за вывод изображений
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont font, fontSmall;
    InputKeyboard keyboard;

    ScreenIntro screenIntro;
    ScreenGame screenGame;
    ScreenSettings screenSettings;
    ScreenAbout screenAbout;
    Texture img; // коммент

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();
        createFont();
        keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT, 10);

        screenIntro = new ScreenIntro(this);
        screenGame = new ScreenGame(this);
        screenSettings = new ScreenSettings(this);
        screenAbout = new ScreenAbout(this);

        setScreen(screenIntro);
    }

    void createFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("wellwait.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = 50;
        parameter.color = Color.ORANGE;
        parameter.borderWidth = 3;
        parameter.borderColor = Color.BLACK;
        font = generator.generateFont(parameter);
        parameter.size = 20;
        fontSmall = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
