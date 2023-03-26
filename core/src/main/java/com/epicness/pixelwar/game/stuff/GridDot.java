package com.epicness.pixelwar.game.stuff;

import static com.epicness.pixelwar.game.constants.GameConstants.GRID_DOT_RADIUS;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.shapes.Circle;

public class GridDot extends Circle {

    public final DelayedRemovalArray<GridLine> outLines, inLines;
    private Color initialColor;

    public GridDot(float x, float y, Color color) {
        super(x, y, GRID_DOT_RADIUS, color);
        outLines = new DelayedRemovalArray<>();
        inLines = new DelayedRemovalArray<>();
        initialColor = color;
    }

    public Color getInitialColor() {
        return initialColor;
    }

    public void setInitialColor(Color initialColor) {
        this.initialColor = initialColor;
    }
}