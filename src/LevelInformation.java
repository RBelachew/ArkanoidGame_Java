//ID: 324488287
import java.util.List;

/**
 * The LevelInformation interface specifies the information required to fully describe a level.
 */
public interface LevelInformation {
    /**
     * Returns the number of balls.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return list of velocities of the balls
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed.
     *
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * Paddle width.
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * Returns the name of the level.
     * The level name will be displayed at the top of the screen.
     *
     * @return the name of the level(a string)
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the list of blocks
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return the number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}