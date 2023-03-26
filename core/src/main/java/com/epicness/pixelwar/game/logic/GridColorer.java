package com.epicness.pixelwar.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_CELL_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_CELL_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.pixelwar.game.stuff.GridCell;

public class GridColorer extends GameLogicHandler {

    private float time;

    public void update(float delta) {
        time += delta / 2f;
        if (time > 2f) {
            time -= 2f;
        }
        for (int column = 0; column < GRID_CELL_COLUMNS; column++) {
            for (int row = 0; row < GRID_CELL_ROWS; row++) {
                GridCell square = stuff.getPixelGrid().cells[column][row];
                float progress = square.getInitialAlpha() + time;
                if (progress > 2f) {
                    progress -= 2f;
                }
                float alpha = progress > 1f ? 2f - progress : progress;
                alpha = Math.min(alpha, 0.4f);
                Color color = square.getInitialColor().cpy().lerp(CLEAR, alpha);
                square.setColor(color);
            }
        }
    }
}