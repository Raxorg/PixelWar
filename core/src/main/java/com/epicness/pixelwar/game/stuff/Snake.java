package com.epicness.pixelwar.game.stuff;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.epicness.pixelwar.game.constants.GameConstants.SNAKE_HEAD_RADIUS;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.constants.Direction;
import com.epicness.fundamentals.stuff.shapes.Circle;

public class Snake extends Circle {

    private GridDot origin, destination;
    private Direction direction;
    private int destinationColumn, destinationRow;
    private float progress;
    public final DelayedRemovalArray<GridLine> lines;

    public Snake(Direction direction) {
        super(SNAKE_HEAD_RADIUS);
        this.direction = direction;
        lines = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
    }

    public void drawTrail(ShapeRenderer shapeRenderer) {
        shapeRenderer.set(Filled);
        for (int i = 0; i < lines.size; i++) {
            lines.get(i).draw(shapeRenderer);
        }
    }

    public GridDot getOrigin() {
        return origin;
    }

    public void setOrigin(GridDot origin) {
        this.origin = origin;
    }

    public GridDot getDestination() {
        return destination;
    }

    public void setDestination(GridDot destination) {
        this.destination = destination;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getDestinationColumn() {
        return destinationColumn;
    }

    public void setDestinationColumn(int destinationColumn) {
        this.destinationColumn = destinationColumn;
    }

    public int getDestinationRow() {
        return destinationRow;
    }

    public void setDestinationRow(int destinationRow) {
        this.destinationRow = destinationRow;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }
}