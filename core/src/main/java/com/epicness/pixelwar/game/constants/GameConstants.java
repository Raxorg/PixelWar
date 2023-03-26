package com.epicness.pixelwar.game.constants;

import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Grid
    public static final float GRID_VERTICAL_MARGIN = 100f;
    private static final float AVAILABLE_WIDTH = CAMERA_WIDTH - GRID_VERTICAL_MARGIN * 2f;
    private static final float AVAILABLE_HEIGHT = CAMERA_HEIGHT - GRID_VERTICAL_MARGIN * 2f;
    public static final int GRID_CELL_ROWS = 20;
    public static final float POINT_SPACING = AVAILABLE_HEIGHT / GRID_CELL_ROWS;
    public static final float CELL_SIZE = POINT_SPACING;
    public static final int GRID_CELL_COLUMNS = (int) (AVAILABLE_WIDTH / CELL_SIZE);
    public static final float GRID_HORIZONTAL_MARGIN = (CAMERA_WIDTH - GRID_CELL_COLUMNS * CELL_SIZE) / 2f;
    public static final int GRID_DOT_COLUMNS = GRID_CELL_COLUMNS + 1;
    public static final int GRID_DOT_ROWS = GRID_CELL_ROWS + 1;
    public static final float GRID_DOT_RADIUS = 5f;
    // Snake
    public static final float SNAKE_HEAD_RADIUS = 7f;
    public static final int STARTING_COLUMN = 0;
    public static final int STARTING_ROW = 0;
    public static final int INITIAL_DESTINATION_COLUMN = 1;
    public static final int INITIAL_DESTINATION_ROW = 0;
    public static final float CELLS_PER_SECOND = 4f;
    public static final float LINE_WIDTH = 3f;
    // Trail
    public static final float LINE_EXPIRATION = 4f;
    public static final float LINE_DISAPPEARANCE = LINE_EXPIRATION + 1f;
}