package com.epicness.pixelwar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.epicness.fundamentals.SharedResources;
import com.epicness.pixelwar.game.GameInitializer;
import com.epicness.pixelwar.game.assets.GameAssets;

public class PixelWarGame extends Game {

    private GLProfiler profiler;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initAssets();
        new GameInitializer(assets).initialize(new SharedResources());

        profiler = new GLProfiler(Gdx.graphics);
        profiler.enable();
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render() {
        super.render();
        batch.begin();
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, 20);
        font.draw(batch, "Draw calls: " + profiler.getDrawCalls(), 10, 40);
        font.draw(batch, "Texture bindings: " + profiler.getTextureBindings(), 10, 60);
        batch.end();
        profiler.reset();
    }
}