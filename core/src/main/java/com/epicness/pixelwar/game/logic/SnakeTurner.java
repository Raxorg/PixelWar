package com.epicness.pixelwar.game.logic;

import static com.epicness.fundamentals.constants.Direction.DOWN;
import static com.epicness.fundamentals.constants.Direction.LEFT;
import static com.epicness.fundamentals.constants.Direction.RIGHT;
import static com.epicness.fundamentals.constants.Direction.UP;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_ROWS;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_COLUMN;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_ROW;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.constants.Direction;
import com.epicness.fundamentals.stuff.shapes.Circle;
import com.epicness.pixelwar.game.stuff.GridDot;

public class SnakeTurner extends GameLogicHandler {

    private Direction direction;
    private int destinationColumn, destinationRow;

    @Override
    protected void init() {
        direction = RIGHT;
        destinationColumn = INITIAL_DESTINATION_COLUMN;
        destinationRow = INITIAL_DESTINATION_ROW;
    }

    public void setNextDirection(Direction direction) {
        this.direction = direction;
    }

    public Void turn() {
        switch (direction) {
            case UP:
                if (++destinationRow >= GRID_DOT_ROWS) {
                    destinationRow--;
                    direction = MathUtils.randomBoolean() ? LEFT : RIGHT;
                    return turn();
                }
                break;
            case LEFT:
                if (--destinationColumn < 0) {
                    destinationColumn++;
                    direction = MathUtils.randomBoolean() ? UP : DOWN;
                    return turn();
                }
                break;
            case DOWN:
                if (--destinationRow < 0) {
                    destinationRow++;
                    direction = MathUtils.randomBoolean() ? LEFT : RIGHT;
                    return turn();
                }
                break;
            case RIGHT:
                if (++destinationColumn >= GRID_DOT_COLUMNS) {
                    destinationColumn--;
                    direction = MathUtils.randomBoolean() ? UP : DOWN;
                    return turn();
                }
        }
        GridDot destination = stuff.getPixelGrid().dots[destinationColumn][destinationRow];
        logic.get(SnakeController.class).setDestination(destination);
        return null;
    }
}