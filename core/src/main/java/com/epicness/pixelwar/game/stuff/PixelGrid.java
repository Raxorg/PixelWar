package com.epicness.pixelwar.game.stuff;

import static com.badlogic.gdx.graphics.Color.GRAY;
import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.epicness.pixelwar.game.constants.GameConstants.CELL_SIZE;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_CELL_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_CELL_ROWS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_ROWS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_HORIZONTAL_MARGIN;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_VERTICAL_MARGIN;
import static com.epicness.pixelwar.game.constants.GameConstants.POINT_SPACING;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class PixelGrid {

    public final GridCell[][] cells;
    public final GridDot[][] dots;

    public PixelGrid() {
        cells = new GridCell[GRID_CELL_COLUMNS][];
        dots = new GridDot[GRID_DOT_COLUMNS][];
        for (int column = 0; column < GRID_DOT_COLUMNS; column++) {
            if (column != GRID_CELL_COLUMNS) {
                cells[column] = new GridCell[GRID_CELL_ROWS];
            }
            dots[column] = new GridDot[GRID_DOT_ROWS];
            for (int row = 0; row < GRID_DOT_ROWS; row++) {
                float x = GRID_HORIZONTAL_MARGIN + column * POINT_SPACING;
                float y = GRID_VERTICAL_MARGIN + row * POINT_SPACING;

                if (column != GRID_CELL_COLUMNS && row != GRID_CELL_ROWS) {
                    cells[column][row] = new GridCell(x, y, CELL_SIZE, CELL_SIZE);
                    cells[column][row].setInitialAlpha(MathUtils.random(2f));
                }

                dots[column][row] = new GridDot(x, y, GRAY);
            }
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.set(Filled);
        for (int column = 0; column < GRID_DOT_COLUMNS; column++) {
            for (int row = 0; row < GRID_DOT_ROWS; row++) {
                if (column != GRID_CELL_COLUMNS && row != GRID_CELL_ROWS) {
                    cells[column][row].draw(shapeRenderer);
                }
                dots[column][row].draw(shapeRenderer);
            }
        }
    }
}