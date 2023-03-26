package com.epicness.pixelwar.game.logic;

import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.pixelwar.game.constants.GameConstants.CELLS_PER_SECOND;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_COLUMN;
import static com.epicness.pixelwar.game.constants.GameConstants.INITIAL_DESTINATION_ROW;
import static com.epicness.pixelwar.game.constants.GameConstants.STARTING_COLUMN;
import static com.epicness.pixelwar.game.constants.GameConstants.STARTING_ROW;

import com.badlogic.gdx.math.Vector2;
import com.epicness.pixelwar.game.stuff.GridDot;

public class SnakeController extends GameLogicHandler {

    private GridDot origin, destination;
    private float progress;

    @Override
    protected void init() {
        origin = stuff.getPixelGrid().dots[STARTING_COLUMN][STARTING_ROW];
        destination = stuff.getPixelGrid().dots[INITIAL_DESTINATION_COLUMN][INITIAL_DESTINATION_ROW];
        stuff.getSnakeHead().setPosition(origin.getPosition());
        logic.get(TrailHandler.class).spawnTrail(origin, destination, WHITE);
    }

    public void update(float delta) {
        progress = Math.min(progress + delta * CELLS_PER_SECOND, 1f);
        Vector2 position = origin.getPosition().cpy().lerp(destination.getPosition(), progress);
        stuff.getSnakeHead().setPosition(position);
        logic.get(TrailHandler.class).update(position, delta);
        if (progress == 1f) {
            origin = destination;
            logic.get(SnakeTurner.class).turn();
            logic.get(TrailHandler.class).spawnTrail(origin, destination, WHITE);
            progress = 0f;
        }
    }

    public void setDestination(GridDot destination) {
        this.destination = destination;
    }
}