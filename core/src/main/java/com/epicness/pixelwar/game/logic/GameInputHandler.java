package com.epicness.pixelwar.game.logic;

import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.E;
import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.UP;

import com.epicness.fundamentals.constants.Direction;
import com.epicness.fundamentals.input.InputHandler;
import com.epicness.pixelwar.game.stuff.GameStuff;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case E:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake1(), Direction.UP);
                break;
            case S:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake1(), Direction.LEFT);
                break;
            case D:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake1(), Direction.DOWN);
                break;
            case F:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake1(), Direction.RIGHT);
                break;
            case UP:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake2(), Direction.UP);
                break;
            case LEFT:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake2(), Direction.LEFT);
                break;
            case DOWN:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake2(), Direction.DOWN);
                break;
            case RIGHT:
                logic.get(SnakeTurner.class).setNextDirection(stuff.getSnake2(), Direction.RIGHT);
                break;
        }
    }
}