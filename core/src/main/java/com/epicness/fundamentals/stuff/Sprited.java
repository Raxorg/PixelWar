package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.interfaces.Actor;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;

public class Sprited implements Buttonable, Actor {

    private final Sprite sprite;

    public Sprited(Sprite sprite) {
        this.sprite = new Sprite(sprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        Rectangle bounds = sprite.getBoundingRectangle();
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void setSprite(Sprite sprite) {
        this.sprite.setRegion(sprite);
    }

    @Override
    public boolean contains(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    @Override
    public void translateX(float amount) {
        sprite.translateX(amount);
    }

    @Override
    public void translateY(float amount) {
        sprite.translateY(amount);
    }

    public Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    public void stretchWidth(float amount) {
        sprite.setSize(getWidth() + amount, getHeight());
    }

    @Override
    public void stretchHeight(float amount) {
        sprite.setSize(getWidth(), getHeight() + amount);
    }

    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    @Override
    public void rotate(float degrees) {
        sprite.rotate(degrees);
    }

    public void setOriginBasedPosition(float x, float y) {
        sprite.setOriginBasedPosition(x, y);
    }

    public float getCenterX() {
        return sprite.getX() + sprite.getWidth() / 2f;
    }

    public float getCenterY() {
        return sprite.getY() + sprite.getHeight() / 2f;
    }

    public Vector2 getCenter() {
        return new Vector2(getCenterX(), getCenterY());
    }

    public float getOriginBasedX() {
        return sprite.getX() + sprite.getOriginX();
    }

    public float getOriginBasedY() {
        return sprite.getY() + sprite.getOriginY();
    }

    public Vector2 getOriginBasedCenter() {
        return new Vector2(getOriginBasedX(), getOriginBasedY());
    }

    public Vector2 getScale() {
        return new Vector2(sprite.getScaleX(), sprite.getScaleY());
    }

    public void setScale(float scale) {
        sprite.setScale(scale);
    }

    public float getOriginX() {
        return sprite.getOriginX();
    }

    public float getOriginY() {
        return sprite.getOriginY();
    }

    public void setOrigin(float originX, float originY) {
        sprite.setOrigin(originX, originY);
    }

    public void setOriginCenter() {
        sprite.setOriginCenter();
    }

    public float getRotation() {
        return sprite.getRotation();
    }

    public void setRotation(float degrees) {
        sprite.setRotation(degrees);
    }

    public boolean isFlipX() {
        return sprite.isFlipX();
    }

    public void setFlip(boolean flipX, boolean flipY) {
        sprite.setFlip(flipX, flipY);
    }

    public Color getColor() {
        return sprite.getColor();
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }

    public Sprite getSprite() {
        return sprite;
    }
}