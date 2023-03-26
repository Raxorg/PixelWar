package com.epicness.pixelwar.game.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.shapes.Square;

public class GridCell extends Square {

    private float initialAlpha;
    private Color initialColor;

    public GridCell(float x, float y, float width, float height) {
        super(x, y, width, height);
        initialColor = CLEAR;
    }

    public float getInitialAlpha() {
        return initialAlpha;
    }

    public void setInitialAlpha(float initialAlpha) {
        this.initialAlpha = initialAlpha;
    }

    public Color getInitialColor() {
        return initialColor;
    }

    public void setInitialColor(Color initialColor) {
        this.initialColor = initialColor;
    }
}