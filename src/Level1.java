//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 1 of the game.implements the interface LevelInformation.
 */
public class Level1 implements LevelInformation {

    private List<Block> blocks;

    /**
     * Instantiates a new Level1.
     * Instantiates a list of blocks.
     */
    public Level1() {
        this.blocks = new ArrayList<>();
        this.blocks.add(new Block(new Rectangle(new Point(400 - 20, 200), 40, 40), Color.RED, 1));
    }
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        velocities.add(new Velocity(0, -5));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                //A black screen
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, 800, 600);
                //Three circles
                d.setColor(Color.BLUE);
                d.drawCircle(400, 220, 50);
                d.drawCircle(400, 220, 70);
                d.drawCircle(400, 220, 90);
                //Two perpendicular lines
                d.drawLine(400, 100, 400, 340);
                d.drawLine(300, 220, 500, 220);
            }

            @Override
            public void timePassed() {
            }
        };
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}