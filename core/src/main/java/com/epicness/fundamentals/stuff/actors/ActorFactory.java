package com.epicness.fundamentals.stuff.actors;

import com.epicness.fundamentals.stuff.interfaces.Actor;

public abstract class ActorFactory<A extends Actor> {

    protected final Object[] parameters;

    public ActorFactory(Object... parameters) {
        this.parameters = parameters;
    }

    public abstract A build();
}