package com.epicness.pixelwar.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.epicness.pixelwar.game.constants.GameConstants.LINE_DISAPPEARANCE;
import static com.epicness.pixelwar.game.constants.GameConstants.LINE_EXPIRATION;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.pixelwar.game.stuff.GridDot;
import com.epicness.pixelwar.game.stuff.GridLine;
import com.epicness.pixelwar.game.stuff.Snake;

public class TrailHandler extends GameLogicHandler {

    public void spawnTrail(Snake snake) {
        GridDot origin = snake.getOrigin();
        GridDot ending = snake.getDestination();
        origin.setColor(snake.getColor());
        GridLine line = new GridLine(origin, ending, snake.getColor());
        line.setPoint1(origin.getPosition());
        line.setPoint2(origin.getPosition());
        snake.lines.add(line);
    }

    public void update(Snake snake, float delta) {
        DelayedRemovalArray<GridLine> lines = snake.lines;
        Vector2 position = snake.getPosition();
        updateTrail(lines, position);
        updateLines(lines, delta);
    }

    private void updateTrail(DelayedRemovalArray<GridLine> lines, Vector2 position) {
        GridLine line = lines.get(lines.size - 1);
        line.setPoint2(position);
    }

    private void updateLines(DelayedRemovalArray<GridLine> lines, float delta) {
        lines.begin();
        for (int l = 0; l < lines.size; l++) {
            GridLine line = lines.get(l);
            float time = line.time += delta;
            if (time >= LINE_EXPIRATION) {
                float progress = Math.min(MathUtils.map(LINE_EXPIRATION, LINE_DISAPPEARANCE, 0f, 1f, time), 1f);
                line.setColor(line.initialColor.cpy().lerp(CLEAR, progress));

                updateOriginDotColor(line);

                if (time >= LINE_DISAPPEARANCE) {
                    line.origin.outLines.removeValue(line, true);
                    line.ending.inLines.removeValue(line, true);
                    lines.removeValue(line, true);
                }
            }
        }
        lines.end();
    }

    private void updateOriginDotColor(GridLine line) {
        GridLine strongestLine = line;
        GridDot origin = line.origin;
        float strongestA = line.getColor().a;
        for (int i = 0; i < origin.inLines.size; i++) {
            float a = origin.inLines.get(i).getColor().a;
            if (a > strongestA) {
                strongestLine = origin.inLines.get(i);
                strongestA = a;
            }
        }
        for (int i = 0; i < origin.outLines.size; i++) {
            float a = origin.outLines.get(i).getColor().a;
            if (a > strongestA) {
                strongestLine = origin.outLines.get(i);
                strongestA = a;
            }
        }
        float alpha = strongestLine.getColor().a;
        origin.setColor(origin.getInitialColor().cpy().lerp(strongestLine.getColor(), alpha));
    }
}