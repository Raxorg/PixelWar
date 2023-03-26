package com.epicness.fundamentals.stuff.grid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.actors.ActorFactory;
import com.epicness.fundamentals.stuff.interfaces.Actor;

import java.util.ArrayList;
import java.util.List;

public class Grid<A extends Actor> {

    protected final int columns, rows;
    private final List<List<Cell<A>>> cells;

    public Grid(int columns, int rows, ActorFactory<A> actorFactory) {
        this.columns = columns;
        this.rows = rows;
        cells = new ArrayList<>();
        for (int column = 0; column < columns; column++) {
            cells.add(new ArrayList<>());
            for (int row = 0; row < rows; row++) {
                cells.get(column).add(new Cell<>(actorFactory.build(), column, row));
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                cells.get(column).get(row).actor.draw(spriteBatch);
            }
        }
    }

    public void setCellSize(float size) {
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                cells.get(column).get(row).actor.setPosition(column * size, row * size);
                cells.get(column).get(row).actor.setSize(size);
            }
        }
    }

    public void translate(float x, float y) {
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                cells.get(column).get(row).actor.translate(x, y);
            }
        }
    }

    public float getWidth() {
        return columns * cells.get(0).get(0).actor.getWidth();
    }

    public float getHeight() {
        return rows * cells.get(0).get(0).actor.getHeight();
    }

    public List<List<Cell<A>>> getCells() {
        return cells;
    }
}