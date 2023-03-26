package com.epicness.fundamentals.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Assets {

    private final AssetManager assetManager;
    private boolean assetsInitialized = false;

    public Assets() {
        assetManager = new AssetManager();
    }

    public abstract void queueAssetLoading();

    /* Default recommended way of loading assets -> async */
    public final boolean loadAssets() {
        return assetManager.update();
    }

    /* Obstructing way of loading assets -> blocks rendering until finished */
    public final void finishLoading() {
        assetManager.finishLoading();
    }

    public final void initAssets() {
        initializeAssets();
        assetsInitialized = true;
    }

    protected abstract void initializeAssets();

    public final boolean areAssetsInitialized() {
        return assetsInitialized;
    }

    // Loading
    protected final void loadTexture(String path) {
        assetManager.load(path, Texture.class);
    }

    protected final void loadMusic(String path) {
        assetManager.load(path, Music.class);
    }

    protected final void loadSound(String path) {
        assetManager.load(path, Sound.class);
    }

    protected final void loadFont(String path) {
        assetManager.load(path, BitmapFont.class);
    }

    // Getting
    protected final Texture getTexture(String path) {
        return assetManager.get(path, Texture.class);
    }

    protected final Texture getLinearTexture(String path) {
        Texture texture = getTexture(path);
        texture.setFilter(Linear, Linear);
        return texture;
    }

    protected final Sprite getSprite(String path) {
        return new Sprite(getTexture(path));
    }

    protected Sprite getSprite(String path, int regionWidth, int regionHeight) {
        return getSprite(path, 0, 0, regionWidth, regionHeight);
    }

    protected Sprite getSprite(String path, int regionX, int regionY, int regionWidth, int regionHeight) {
        return new Sprite(getTexture(path), regionX, regionY, regionWidth, regionHeight);
    }

    protected final Sprite getLinearSprite(String path) {
        return new Sprite(getLinearTexture(path));
    }

    protected final Sprite getLinearSprite(String path, int regionWidth, int regionHeight) {
        return new Sprite(getLinearTexture(path), 0, 0, regionWidth, regionHeight);
    }

    protected final Sprite getLinearSprite(String path, int regionX, int regionY, int regionWidth, int regionHeight) {
        return new Sprite(getLinearTexture(path), regionX, regionY, regionWidth, regionHeight);
    }

    protected final Music getMusic(String path) {
        return assetManager.get(path, Music.class);
    }

    protected final Sound getSound(String path) {
        return assetManager.get(path, Sound.class);
    }

    protected final BitmapFont getFont(String path) {
        return assetManager.get(path, BitmapFont.class);
    }

    protected final BitmapFont getFont(String path, float scale) {
        BitmapFont font = getFont(path);
        font.getData().setScale(scale);
        return font;
    }

    protected final BitmapFont getLinearFont(String path) {
        BitmapFont font = getFont(path);
        font.getRegion().getTexture().setFilter(Linear, Linear);
        return font;
    }

    protected final BitmapFont getLinearFont(String path, float scale) {
        BitmapFont font = getLinearFont(path);
        font.getData().setScale(scale);
        return font;
    }
}