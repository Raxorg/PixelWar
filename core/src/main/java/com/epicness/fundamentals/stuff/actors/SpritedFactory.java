package com.epicness.fundamentals.stuff.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.Sprited;

public class SpritedFactory extends ActorFactory<Sprited> {

    public SpritedFactory(Sprite sprite) {
        super(sprite);
    }

    @Override
    public Sprited build() {
        return new Sprited((Sprite) parameters[0]);
    }
}