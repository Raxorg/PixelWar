package com.epicness.fundamentals.stuff.shapes;

import static com.badlogic.gdx.graphics.Color.GRAY;
import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.interfaces.Movable;

public class Circle implements Movable {

    private float x, y, radius;
    private Color color;

    public Circle(float x, float y, float radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public Circle(float x, float y, float radius) {
        this(x, y, radius, GRAY);
    }

    public Circle(float radius) {
        this(0f, 0f, radius);
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }

    public void drawContour(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color.cpy().set(1 - color.r, 1 - color.g, 1 - color.b, 1f));
        shapeRenderer.set(Line);
        shapeRenderer.circle(x, y, radius);
    }

    public float getCenterX() {
        return x;
    }

    public Vector2 getCenter() {
        return new Vector2(x, y);
    }

    public float getEndX() {
        return x + radius;
    }

    @Override
    public void translateX(float amount) {
        x += amount;
    }

    @Override
    public void translateY(float amount) {
        y += amount;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}