package com.epicness.fundamentals.stuff.interfaces;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface Drawable {

    default void draw(Batch batch) {
    }

    default void draw(ShapeRenderer shapeRenderer) {
    }
}