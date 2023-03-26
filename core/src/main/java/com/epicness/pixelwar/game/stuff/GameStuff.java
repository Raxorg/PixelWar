package com.epicness.pixelwar.game.stuff;

import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.pixelwar.game.constants.GameConstants.SNAKE_HEAD_RADIUS;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.shapes.Circle;
import com.epicness.pixelwar.game.assets.GameAssets;

public class GameStuff extends Stuff<GameAssets> {

    private PixelGrid pixelGrid;
    private DelayedRemovalArray<GridLine> lines;
    private Circle snakeHead;

    @Override
    public void initializeStuff() {
        pixelGrid = new PixelGrid();
        lines = new DelayedRemovalArray<>();

        snakeHead = new Circle(SNAKE_HEAD_RADIUS);
        snakeHead.setColor(WHITE);
    }

    public PixelGrid getPixelGrid() {
        return pixelGrid;
    }

    public DelayedRemovalArray<GridLine> getLines() {
        return lines;
    }

    public Circle getSnakeHead() {
        return snakeHead;
    }
}