import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 3 of the game.implements the interface LevelInformation.
 */
public class Level3 implements LevelInformation {

    private List<Block> blocks;

    /**
     * Instantiates a new Level 3.
     * Instantiates a list of blocks.
     */
    public Level3() {
        this.blocks = new ArrayList<>();

        //Creates line of blocks
        int x = 725;
        int y = 140;
        int width = 50;
        int height = 30;
        for (int i = 0; i < 10; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(x, y), width, height), Color.GRAY, 2));
            x = x - 50;
        }
        //Creates line of blocks
        x = 725;
        y = 170;
        width = 50;
        height = 30;
        for (int i = 0; i < 9; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(x, y), width, height), Color.RED, 1));
            x = x - 50;
        }
        //Creates line of blocks
        x = 725;
        y = 200;
        width = 50;
        height = 30;
        for (int i = 0; i < 8; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(x, y), width, height), Color.YELLOW, 1));
            x = x - 50;
        }
        //Creates line of blocks
        x = 725;
        y = 230;
        width = 50;
        height = 30;
        for (int i = 0; i < 7; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(x, y), width, height), Color.BLUE, 1));
            x = x - 50;
        }
        //Creates line of blocks
        x = 725;
        y = 260;
        width = 50;
        height = 30;
        for (int i = 0; i < 6; i++) {
            this.blocks.add(new Block(new Rectangle(new Point(x, y), width, height), Color.WHITE, 1));
            x = x - 50;
        }

    }
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        velocities.add(new Velocity(5, -5));
        velocities.add(new Velocity(-5, -5));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                //A green screen
                d.setColor(Color.GREEN.darker().darker());
                d.fillRectangle(0, 0, 800, 600);
                //The lower rectangle
                d.setColor(Color.DARK_GRAY.darker().darker());
                d.fillRectangle(50, 450, 90, 150);
                //Windows
                d.setColor(Color.WHITE);
                int dy = 460;
                for (int j = 0; j < 4; j++) {
                    int dx = 60;
                    for (int i = 0; i < 4; i++) {
                        d.fillRectangle(dx, dy, 10, 30);
                        dx += 20;
                    }
                    dy += 60;
                }
                //The upper rectangle
                d.setColor(Color.DARK_GRAY);
                d.fillRectangle(90, 200, 15, 250);
                //Circles
                d.setColor(Color.orange);
                d.fillCircle(97, 200, 15);
                d.setColor(Color.RED);
                d.fillCircle(97, 200, 10);
                d.setColor(Color.WHITE);
                d.fillCircle(97, 200, 5);
                //The middle rectangle
                d.setColor(Color.DARK_GRAY.darker());
                d.fillRectangle(75, 350, 45, 100);

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
