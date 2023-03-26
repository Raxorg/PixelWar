package com.epicness.pixelwar.game;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.pixelwar.game.stuff.GameStuff;

public class GameRenderer extends Renderer<GameStuff> {

    @Override
    public void render() {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        ScreenUtils.clear(BLACK);
        shapeRenderer.begin();
        stuff.getPixelGrid().draw(shapeRenderer);
        stuff.getSnake1().draw(shapeRenderer);
        stuff.getSnake2().draw(shapeRenderer);
        shapeRenderer.end();
    }
}