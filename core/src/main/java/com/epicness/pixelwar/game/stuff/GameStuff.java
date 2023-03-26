package com.epicness.pixelwar.game.stuff;

import static com.epicness.fundamentals.constants.Direction.LEFT;
import static com.epicness.fundamentals.constants.Direction.RIGHT;

import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.utils.Random;
import com.epicness.pixelwar.game.assets.GameAssets;

public class GameStuff extends Stuff<GameAssets> {

    private PixelGrid pixelGrid;
    private Snake player1, player2;

    @Override
    public void initializeStuff() {
        pixelGrid = new PixelGrid();

        player1 = new Snake(RIGHT);
        player1.setColor(Random.rainbowColor());

        player2 = new Snake(LEFT);
        player2.setColor(Random.rainbowExcludedColor(player1.getColor()));
    }

    public PixelGrid getPixelGrid() {
        return pixelGrid;
    }

    public Snake getSnake1() {
        return player1;
    }

    public Snake getSnake2() {
        return player2;
    }
}