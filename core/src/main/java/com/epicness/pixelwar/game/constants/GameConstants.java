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
    public static final float GRID_DOT_RADIUS = 4f;
    // Player 1
    public static final int STARTING_COLUMN_1 = 0;
    public static final int STARTING_ROW_1 = 0;
    public static final int INITIAL_DESTINATION_COLUMN_1 = 1;
    public static final int INITIAL_DESTINATION_ROW_1 = 0;
    // Player 2
    public static final int STARTING_COLUMN_2 = GRID_CELL_COLUMNS;
    public static final int STARTING_ROW_2 = GRID_CELL_ROWS;
    public static final int INITIAL_DESTINATION_COLUMN_2 = GRID_CELL_COLUMNS - 1;
    public static final int INITIAL_DESTINATION_ROW_2 = GRID_CELL_ROWS;
    // Snakes
    public static final float SNAKE_HEAD_RADIUS = 9f;
    public static final float DEFAULT_CELLS_PER_SECOND = 7f;
    public static final float LINE_WIDTH = 5f;
    // Trail
    public static final float LINE_EXPIRATION = 5f;
    public static final float LINE_DISAPPEARANCE = LINE_EXPIRATION + 1f;
}