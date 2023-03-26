package com.epicness.pixelwar.game.stuff;

import static com.epicness.pixelwar.game.constants.GameConstants.LINE_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.shapes.Line;

public class GridLine extends Line {

    public final GridDot origin, ending;
    public final Color initialColor;
    public float time;

    public GridLine(GridDot origin, GridDot ending, Color initialColor) {
        super(LINE_WIDTH);
        this.origin = origin;
        this.origin.outLines.add(this);
        this.ending = ending;
        this.initialColor = initialColor;
        setColor(initialColor);
    }
}