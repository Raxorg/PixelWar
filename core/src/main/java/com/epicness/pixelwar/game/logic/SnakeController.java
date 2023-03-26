package com.epicness.pixelwar.game.logic;

import static com.epicness.pixelwar.game.constants.GameConstants.DEFAULT_CELLS_PER_SECOND;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_COLUMN_1;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_COLUMN_2;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_ROW_1;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_ROW_2;
import static com.epicness.pixelwar.game.constants.GameConstants.STARTING_COLUMN_1;
import static com.epicness.pixelwar.game.constants.GameConstants.STARTING_COLUMN_2;
import static com.epicness.pixelwar.game.constants.GameConstants.STARTING_ROW_1;
import static com.epicness.pixelwar.game.constants.GameConstants.STARTING_ROW_2;

import com.badlogic.gdx.math.Vector2;
import com.epicness.pixelwar.game.stuff.GridDot;
import com.epicness.pixelwar.game.stuff.Snake;

public class SnakeController extends GameLogicHandler {

    @Override
    protected void init() {
        GridDot[][] dots = stuff.getPixelGrid().dots;
        GridDot origin = dots[STARTING_COLUMN_1][STARTING_ROW_1];
        GridDot destination = dots[INITIAL_DESTINATION_COLUMN_1][INITIAL_DESTINATION_ROW_1];
        initSnake(stuff.getSnake1(), origin, destination);

        origin = dots[STARTING_COLUMN_2][STARTING_ROW_2];
        destination = dots[INITIAL_DESTINATION_COLUMN_2][INITIAL_DESTINATION_ROW_2];
        initSnake(stuff.getSnake2(), origin, destination);
    }

    private void initSnake(Snake snake, GridDot origin, GridDot destination) {
        snake.setOrigin(origin);
        snake.setDestination(destination);
        snake.setPosition(origin.getPosition());
        logic.get(TrailHandler.class).spawnTrail(snake);
    }

    public void update(float delta) {
        updateSnake(stuff.getSnake1(), delta);
        updateSnake(stuff.getSnake2(), delta);
    }

    private void updateSnake(Snake snake, float delta) {
        GridDot origin = snake.getOrigin();
        GridDot destination = snake.getDestination();
        float progress = Math.min(snake.getProgress() + delta * DEFAULT_CELLS_PER_SECOND, 1f);
        snake.setProgress(progress);
        Vector2 position = origin.getPosition().cpy().lerp(destination.getPosition(), progress);
        snake.setPosition(position);
        logic.get(TrailHandler.class).update(snake, delta);
        if (progress == 1f) {
            snake.setOrigin(destination);
            logic.get(SnakeTurner.class).turn(snake);
            logic.get(TrailHandler.class).spawnTrail(snake);
            snake.setProgress(0f);
        }
    }
}