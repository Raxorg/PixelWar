package com.epicness.fundamentals.constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class SharedConstants {

    // Camera
    public static final float RATIO = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
    public static final float CAMERA_HEIGHT = 1000f;
    public static final float CAMERA_WIDTH = CAMERA_HEIGHT * RATIO;
    public static final float CAMERA_HALF_WIDTH = CAMERA_WIDTH / 2f;
    public static final float CAMERA_HALF_HEIGHT = CAMERA_HEIGHT / 2f;
    // Asset paths
    public static final String EXPLOSION_PATH = "fundamentals/audio/explosionSound.wav";

    public static final String PIXEL_FONT_PATH = "fundamentals/fonts/pixelFont.fnt";
    public static final String TIMES_SQUARE_PATH = "fundamentals/fonts/timesSquare.fnt";

    public static final String CIRCLE_PATH = "fundamentals/images/circle.png";
    public static final String TRIANGLE_PATH = "fundamentals/images/triangle.png";
    public static final String GLOW_PATH = "fundamentals/images/glow.png";
    public static final String PIXEL_PATH = "fundamentals/images/pixel.png";
    public static final String SQUARE_32_PATH = "fundamentals/images/square32.png";
    public static final String SQUARE_32_INVERTED_PATH = "fundamentals/images/square32Inverted.png";
    public static final String WEIRD_SHAPE_PATH = "fundamentals/images/weirdShape.png";
    // Colors
    public static final Color WHITE_CLEAR = new Color(1f, 1f, 1f, 0f);
    public static final Color WHITE_CLEAR_25 = new Color(1, 1, 1, 0.25f);
    public static final Color WHITE_CLEAR_50 = new Color(1, 1, 1, 0.50f);
    public static final Color WHITE_CLEAR_75 = new Color(1, 1, 1, 0.75f);

    public static final Color BLACK_CLEAR_25 = new Color(0, 0, 0, 0.25f);
    public static final Color BLACK_CLEAR_50 = new Color(0, 0, 0, 0.50f);
    public static final Color BLACK_CLEAR_75 = new Color(0, 0, 0, 0.75f);

    public static final Color NAVY_GRAY_50 = new Color(0.25f, 0.25f, 0.5f, 1f);

    public static final Color DIRT = new Color(0xeea160ff);
    public static final Color LIGHT_DIRT = new Color(0xf4cca1ff);
    public static final Color DARK_DIRT = new Color(0x8e4100ff);

    public static final Color GRASS = new Color(0x71aa34ff);
    public static final Color LIGHT_GRASS = new Color(0xb6d53cff);
    public static final Color DARK_GRASS = new Color(0x003000ff);
}