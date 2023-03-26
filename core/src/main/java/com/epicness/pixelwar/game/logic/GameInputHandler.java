package com.epicness.pixelwar.game.logic;

import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.E;
import static com.badlogic.gdx.Input.Keys.F;
import static com.badlogic.gdx.Input.Keys.S;
import static com.epicness.fundamentals.constants.Direction.DOWN;
import static com.epicness.fundamentals.constants.Direction.LEFT;
import static com.epicness.fundamentals.constants.Direction.RIGHT;
import static com.epicness.fundamentals.constants.Direction.UP;

import com.epicness.fundamentals.input.InputHandler;
import com.epicness.pixelwar.game.stuff.GameStuff;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case E:
                logic.get(SnakeTurner.class).setNextDirection(UP);
                break;
            case S:
                logic.get(SnakeTurner.class).setNextDirection(LEFT);
                break;
            case D:
                logic.get(SnakeTurner.class).setNextDirection(DOWN);
                break;
            case F:
                logic.get(SnakeTurner.class).setNextDirection(RIGHT);
                break;
        }
    }
}