//ID: 324488287
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 4 of the game.implements the interface LevelInformation.
 */
public class Level4 implements LevelInformation {

    private List<Block> blocks;

    /**
     * Instantiates a new Level 4.
     * Instantiates a list of blocks.
     */
    public Level4() {
        this.blocks = new ArrayList<>();
        //Array of colors for blocks
        Color[] colors = {
                Color.GRAY,
                Color.RED,
                Color.YELLOW,
                Color.GREEN,
                Color.WHITE,
                Color.PINK,
                Color.cyan
        };
        //7 lines of blocks.15 blocks per line
        int dy = 100;
        for (int j = 0; j < 7; j++) {
            double dx = 25;
            for (int i = 0; i < 15; i++) {
                this.blocks.add(new Block(new Rectangle(new Point(dx, dy), 50, 30), colors[j], 1));
                dx = dx + 50;
            }
            dy = dy + 30;
        }
    }
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        velocities.add(new Velocity(5, -5));
        velocities.add(new Velocity(-5, -5));
        velocities.add(new Velocity(-0, -5));
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                //A cyan screen
                d.setColor(Color.cyan.darker());
                d.fillRectangle(0, 0, 800, 600);

                //lines for wires
                d.setColor(Color.gray);
                d.drawLine(205, 430, 100, 600);
                d.drawLine(265, 400, 100, 600);
                d.drawLine(260, 440, 100, 600);
                d.drawLine(280, 400, 100, 600);
                d.drawLine(205, 440, 100, 600);
                //Circles for balloons
                d.setColor(Color.LIGHT_GRAY);
                d.fillCircle(265, 400, 35);
                d.setColor(Color.gray);
                d.fillCircle(260, 450, 30);
                d.setColor(Color.gray.brighter());
                d.fillCircle(260, 440, 30);
                d.setColor(Color.gray.brighter());
                d.fillCircle(270, 400, 20);
                d.setColor(Color.gray.brighter());
                d.fillCircle(205, 430, 40);

                //lines for wires
                d.setColor(Color.gray);
                d.drawLine(605, 430, 700, 600);
                d.drawLine(665, 400, 700, 600);
                d.drawLine(660, 440, 700, 600);
                d.drawLine(620, 400, 700, 600);
                d.drawLine(605, 440, 700, 600);
                //Circles for balloons
                d.setColor(Color.LIGHT_GRAY);
                d.fillCircle(665, 400, 35);
                d.setColor(Color.gray);
                d.fillCircle(660, 450, 30);
                d.setColor(Color.gray.brighter());
                d.fillCircle(660, 440, 30);
                d.setColor(Color.gray.brighter());
                d.fillCircle(670, 400, 20);
                d.setColor(Color.gray.brighter());
                d.fillCircle(605, 430, 40);
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