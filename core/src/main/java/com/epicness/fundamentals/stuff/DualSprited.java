package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.interfaces.Actor;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;

public class DualSprited implements Actor, Buttonable {

    protected final Sprite background, foreground;
    private boolean backgroundButtonable;

    public DualSprited(Sprite backgroundSprite, Sprite foregroundSprite) {
        background = new Sprite(backgroundSprite);
        foreground = new Sprite(foregroundSprite);
        backgroundButtonable = true;
    }

    public void drawBackground(Batch batch) {
        background.draw(batch);
    }

    public void drawForeground(Batch batch) {
        foreground.draw(batch);
    }

    @Override
    public void draw(Batch batch) {
        drawBackground(batch);
        drawForeground(batch);
    }

    @Override
    public boolean contains(float x, float y) {
        return (backgroundButtonable && background.getBoundingRectangle().contains(x, y))
                || (!backgroundButtonable && foreground.getBoundingRectangle().contains(x, y));
    }

    public void setBackgroundButtonable(boolean backgroundButtonable) {
        this.backgroundButtonable = backgroundButtonable;
    }

    @Override
    public float getY() {
        return background.getY();
    }

    @Override
    public void translateX(float amount) {
        background.translateX(amount);
        foreground.translateX(amount);
    }

    @Override
    public void translateY(float amount) {
        background.translateY(amount);
        foreground.translateY(amount);
    }

    @Override
    public float getX() {
        return background.getX();
    }

    @Override
    public void stretchWidth(float amount) {
        stretchBackgroundWidth(amount);
        stretchForegroundWidth(amount);
    }

    public void stretchBackgroundWidth(float amount) {
        background.setSize(background.getWidth() + amount, background.getHeight());
    }

    public void stretchForegroundWidth(float amount) {
        foreground.setSize(foreground.getWidth() + amount, foreground.getHeight());
    }

    @Override
    public void stretchHeight(float amount) {
        stretchBackgroundHeight(amount);
        stretchForegroundHeight(amount);
    }

    public void stretchBackgroundHeight(float amount) {
        background.setSize(background.getWidth(), background.getHeight() + amount);
    }

    public void stretchForegroundHeight(float amount) {
        foreground.setSize(foreground.getWidth(), foreground.getHeight() + amount);
    }

    @Override
    public float getWidth() {
        return background.getWidth();
    }

    @Override
    public void setWidth(float width) {
        stretchBackgroundWidth(width - background.getWidth());
        stretchForegroundWidth(width - foreground.getWidth());
    }

    @Override
    public float getHeight() {
        return background.getHeight();
    }

    @Override
    public void setHeight(float height) {
        stretchBackgroundHeight(height - background.getHeight());
        stretchForegroundHeight(height - foreground.getHeight());
    }

    @Override
    public void rotate(float degrees) {
        rotateBackground(degrees);
        rotateForeground(degrees);
    }

    public void rotateBackground(float degrees) {
        background.rotate(degrees);
    }

    public void rotateForeground(float degrees) {
        foreground.rotate(degrees);
    }

    public void setForegroundOriginBasedPosition(float x, float y) {
        foreground.setOriginBasedPosition(x, y);
    }

    public void setOriginBasedPosition(float x, float y) {
        background.setOriginBasedPosition(x, y);
        foreground.setOriginBasedPosition(x, y);
    }

    public float getForegroundCenterX() {
        return foreground.getX() + foreground.getWidth() / 2f;
    }

    public float getForegroundCenterY() {
        return foreground.getY() + foreground.getHeight() / 2f;
    }

    public Vector2 getForegroundCenter() {
        return new Vector2(getForegroundCenterX(), getForegroundCenterY());
    }

    public void setBackgroundSize(float width, float height) {
        background.setSize(width, height);
    }

    public void setBackgroundSize(float size) {
        setBackgroundSize(size, size);
    }

    public void setForegroundSize(float width, float height) {
        foreground.setSize(width, height);
    }

    public void setForegroundSize(float size) {
        setForegroundSize(size, size);
    }

    public float getBackgroundWidth() {
        return background.getWidth();
    }

    public float getBackgroundHeight() {
        return background.getHeight();
    }

    public Vector2 getBackgroundSize() {
        return new Vector2(getBackgroundWidth(), getBackgroundHeight());
    }

    public Vector2 getBackgroundScale() {
        return new Vector2(background.getScaleX(), background.getScaleY());
    }

    public void setBackgroundScale(float scale) {
        background.setScale(scale);
    }

    public void setForegroundScale(float scale) {
        foreground.setScale(scale);
    }

    public void setScale(float scale) {
        setBackgroundScale(scale);
        setForegroundScale(scale);
    }

    public void setOrigin(float x, float y) {
        background.setOrigin(x, y);
        foreground.setOrigin(x, y);
    }

    public void setBackgroundOriginCenter() {
        background.setOriginCenter();
    }

    public void setForegroundOriginCenter() {
        foreground.setOriginCenter();
    }

    public void setOriginCenter() {
        setBackgroundOriginCenter();
        setForegroundOriginCenter();
    }

    public void centerBackgroundOnForeground() {
        background.setOriginCenter();
        background.setOriginBasedPosition(getForegroundCenterX(), getForegroundCenterY());
    }

    public void setFlip(boolean flipX, boolean flipY) {
        background.setFlip(flipX, flipY);
        foreground.setFlip(flipX, flipY);
    }

    public Color getBackgroundColor() {
        return background.getColor();
    }

    public Color getForegroundColor() {
        return foreground.getColor();
    }

    public void setBackgroundColor(Color color) {
        background.setColor(color);
    }

    public void setForegroundColor(Color color) {
        foreground.setColor(color);
    }

    public void setColor(Color color) {
        setBackgroundColor(color);
        setForegroundColor(color);
    }

    public float getBackgroundCenterX() {
        return background.getX() + background.getWidth() / 2f;
    }

    public float getBackgroundCenterY() {
        return background.getY() + background.getHeight() / 2f;
    }

    public Vector2 getBackgroundCenter() {
        return new Vector2(getBackgroundCenterX(), getBackgroundCenterY());
    }
}