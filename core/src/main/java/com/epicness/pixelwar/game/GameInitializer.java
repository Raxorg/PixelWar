package com.epicness.pixelwar.game;

import com.epicness.fundamentals.initializer.Initializer;
import com.epicness.pixelwar.game.assets.GameAssets;
import com.epicness.pixelwar.game.logic.GameLogic;
import com.epicness.pixelwar.game.stuff.GameStuff;

public class GameInitializer extends Initializer<GameAssets, GameLogic, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}