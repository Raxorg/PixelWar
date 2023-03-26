package com.epicness.fundamentals.stuff.shapes;

import static com.badlogic.gdx.graphics.Color.GRAY;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Line {

    private float x1, y1, x2, y2;
    private final float width;
    private Color color;

    public Line(float width) {
        this.width = width;
        color = GRAY;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.rectLine(x1, y1, x2, y2, width);
    }

    public void setPoint1(Vector2 point) {
        x1 = point.x;
        y1 = point.y;
    }

    public void setPoint2(Vector2 point) {
        x2 = point.x;
        y2 = point.y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}