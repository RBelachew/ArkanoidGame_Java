//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 2 of the game.implements the interface LevelInformation.
 */
public class Level2 implements LevelInformation {

    private List<Block> blocks;

    /**
     * Instantiates a new Level2.
     * Instantiates a list of blocks.
     */
    public Level2() {
        this.blocks = new ArrayList<>();
        //Array of colors for blocks
        Color[] colors = {
                Color.RED,
                Color.ORANGE,
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                Color.PINK
        };
        int dx = 25;
        for (int i = 0; i < 15; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(dx, 250), 50, 30), colors[(i / 2) % 6], 1));
            dx = dx + 50;
        }
    }
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(30 + (13.3333 * i), 5));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                //A white screen
                d.setColor(Color.WHITE);
                d.fillRectangle(0, 0, 800, 600);
                //Lines for sunbeam
                d.setColor(Color.orange);
                for (int i = 0; i < 200; i++) {
                    d.drawLine(150, 150, 800 - i * 4, 340);
                }
                //Circles
                d.setColor(Color.orange);
                d.fillCircle(150, 150, 60);
                d.setColor(Color.YELLOW);
                d.fillCircle(150, 150, 50);
                d.setColor(Color.orange);
                d.fillCircle(150, 150, 40);


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