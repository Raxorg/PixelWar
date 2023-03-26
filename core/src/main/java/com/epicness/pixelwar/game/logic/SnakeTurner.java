package com.epicness.pixelwar.game.logic;

import static com.epicness.fundamentals.constants.Direction.DOWN;
import static com.epicness.fundamentals.constants.Direction.LEFT;
import static com.epicness.fundamentals.constants.Direction.RIGHT;
import static com.epicness.fundamentals.constants.Direction.UP;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_COLUMNS;
import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_ROWS;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_COLUMN_1;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_COLUMN_2;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_ROW_1;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_ROW_2;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.constants.Direction;
import com.epicness.pixelwar.game.stuff.GridDot;
import com.epicness.pixelwar.game.stuff.Snake;

public class SnakeTurner extends GameLogicHandler {

    @Override
    protected void init() {
        stuff.getSnake1().setDestinationColumn(INITIAL_DESTINATION_COLUMN_1);
        stuff.getSnake1().setDestinationRow(INITIAL_DESTINATION_ROW_1);
        stuff.getSnake2().setDestinationColumn(INITIAL_DESTINATION_COLUMN_2);
        stuff.getSnake2().setDestinationRow(INITIAL_DESTINATION_ROW_2);
    }

    public void setNextDirection(Snake snake, Direction direction) {
        snake.setDirection(direction);
    }

    public Void turn(Snake snake) {
        int destinationColumn = snake.getDestinationColumn();
        int destinationRow = snake.getDestinationRow();
        switch (snake.getDirection()) {
            case UP:
                if (++destinationRow >= GRID_DOT_ROWS) {
                    snake.setDestinationRow(destinationRow - 1);
                    snake.setDirection(MathUtils.randomBoolean() ? LEFT : RIGHT);
                    return turn(snake);
                }
                break;
            case LEFT:
                if (--destinationColumn < 0) {
                    snake.setDestinationColumn(destinationColumn + 1);
                    snake.setDirection(MathUtils.randomBoolean() ? UP : DOWN);
                    return turn(snake);
                }
                break;
            case DOWN:
                if (--destinationRow < 0) {
                    snake.setDestinationRow(destinationRow + 1);
                    snake.setDirection(MathUtils.randomBoolean() ? LEFT : RIGHT);
                    return turn(snake);
                }
                break;
            case RIGHT:
                if (++destinationColumn >= GRID_DOT_COLUMNS) {
                    snake.setDestinationColumn(destinationColumn - 1);
                    snake.setDirection(MathUtils.randomBoolean() ? UP : DOWN);
                    return turn(snake);
                }
        }
        snake.setDestinationColumn(destinationColumn);
        snake.setDestinationRow(destinationRow);
        GridDot destination = stuff.getPixelGrid().dots[destinationColumn][destinationRow];
        snake.setDestination(destination);
        return null;
    }
}