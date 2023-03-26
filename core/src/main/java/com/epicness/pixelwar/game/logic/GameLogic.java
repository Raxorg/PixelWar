package com.epicness.pixelwar.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final GridColorer gridColorer;
    private final SnakeController snakeController;

    public GameLogic() {
        registerHandler(new GameInputHandler());
        registerHandler(gridColorer = new GridColorer());
        registerHandler(snakeController = new SnakeController());
        registerHandler(new SnakeTurner());
        registerHandler(new TrailHandler());
    }

    @Override
    public void update(float delta) {
        gridColorer.update(delta);
        snakeController.update(delta);
    }
}