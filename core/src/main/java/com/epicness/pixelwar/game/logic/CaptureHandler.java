package com.epicness.pixelwar.game.logic;

import static com.epicness.pixelwar.game.constants.GameConstants.GRID_CELL_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_CELL_ROWS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_ROWS;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.pixelwar.game.stuff.GridCell;
import com.epicness.pixelwar.game.stuff.GridDot;
import com.epicness.pixelwar.game.stuff.GridLine;
import com.epicness.pixelwar.game.stuff.Snake;

public class CaptureHandler extends GameLogicHandler {

    public void ownDotReached(Snake snake) {
        GridDot reachedDot = snake.getDestination();
        DelayedRemovalArray<GridLine> outLines = reachedDot.outLines;
        DelayedRemovalArray<GridDot> dots = new DelayedRemovalArray<>();
        for (int i = 0; i < outLines.size; i++) {
            paintPolygon(outLines.get(i).ending, new DelayedRemovalArray<>(), snake.getColor(), dots);
        }
        if (dots.size < 3) {
            return;
        }
        float[] vertices = new float[dots.size * 2];
        for (int i = 0; i < dots.size; i++) {
            vertices[2 * i] = dots.get(i).getX();
            vertices[2 * i + 1] = dots.get(i).getY();
        }
        Polygon polygon = new Polygon();
        polygon.setVertices(vertices);
        GridCell[][] gridCells = stuff.getPixelGrid().cells;
        GridDot[][] gridDots = stuff.getPixelGrid().dots;
        for (int column = 0; column < GRID_DOT_COLUMNS; column++) {
            for (int row = 0; row < GRID_DOT_ROWS; row++) {
                if (column != GRID_CELL_COLUMNS && row != GRID_CELL_ROWS) {
                    GridCell cell = gridCells[column][row];
                    if (polygon.contains(cell.getCenter())) {
                        cell.setInitialColor(snake.getColor());
                        paintDot(gridDots, column, row, snake.getColor());
                        paintDot(gridDots, column + 1, row, snake.getColor());
                        paintDot(gridDots, column + 1, row + 1, snake.getColor());
                        paintDot(gridDots, column, row + 1, snake.getColor());
                    }
                }
            }
        }
    }

    private void paintDot(GridDot[][] gridDots, int column, int row, Color color) {
        column = Math.min(column, GRID_DOT_COLUMNS - 1);
        row = Math.min(row, GRID_DOT_ROWS - 1);
        GridDot dot = gridDots[column][row];
        dot.setColor(color);
        dot.setInitialColor(color);
    }

    private void paintPolygon(GridDot currentDot, DelayedRemovalArray<GridLine> visitedLines, Color color,
                              DelayedRemovalArray<GridDot> dots) {
        DelayedRemovalArray<GridLine> outLines = currentDot.outLines;
        for (int i = 0; i < outLines.size; i++) {
            GridLine outLine = outLines.get(i);
            if (visitedLines.contains(outLine, true)) {
                continue;
            }
            if (!outLine.initialColor.equals(color) || outLine.getColor().a != 1f) {
                continue;
            }
            if (!dots.contains(outLine.ending, true)) {
                dots.add(outLine.ending);
            }
            visitedLines.add(outLine);
            paintPolygon(outLine.ending, visitedLines, color, dots);
        }
    }
}