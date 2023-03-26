package com.epicness.fundamentals.stuff.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.DualSprited;

public class DualSpritedFactory extends ActorFactory<DualSprited> {

    public DualSpritedFactory(Sprite backgroundSprite, Sprite foregroundSprite) {
        super(backgroundSprite, foregroundSprite);
    }

    @Override
    public DualSprited build() {
        return new DualSprited((Sprite) parameters[0], (Sprite) parameters[1]);
    }
}