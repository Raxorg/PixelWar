package com.epicness.fundamentals.stuff.grid;

import com.epicness.fundamentals.stuff.interfaces.Actor;

import java.util.HashMap;

public class Cell<A extends Actor> {

    public final A actor;
    public final int column, row;
    public final HashMap<String, Object> properties;

    public Cell(A actor, int column, int row) {
        this.actor = actor;
        this.column = column;
        this.row = row;
        properties = new HashMap<>();
    }

    public void setProperty(String key, Object property) {
        properties.put(key, property);
    }

    @SuppressWarnings("unchecked")
    public <P> P getProperty(String key) {
        return (P) properties.get(key);
    }
}