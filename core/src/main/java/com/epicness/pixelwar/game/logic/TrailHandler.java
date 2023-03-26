package com.epicness.pixelwar.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.GRAY;
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
        for (int i = 0; i < lines.size; i++) {
            GridLine line = lines.get(i);
            float time = line.time += delta;
            if (time >= LINE_EXPIRATION) {
                float progress = Math.min(MathUtils.map(LINE_EXPIRATION, LINE_DISAPPEARANCE, 0f, 1f, time), 1f);
                line.setColor(line.initialColor.cpy().lerp(CLEAR, progress));
                if (line.origin.connectedLines.size <= 2) {
                    line.origin.setColor(line.initialColor.cpy().lerp(GRAY, progress));
                }
                if (time >= LINE_DISAPPEARANCE) {
                    line.origin.connectedLines.removeValue(line, true);
                    line.ending.connectedLines.removeValue(line, true);
                    lines.removeValue(line, true);
                }
            }
        }
        lines.end();
    }
}