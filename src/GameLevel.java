//ID: 324488287
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;


/**
 * a GameLevel class holds the sprites and the collidables, and it is in charge of the animation.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterOfBlocks;
    private Counter counterOfBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;
    private Counter lives;
    private Paddle paddle;

    /**
     * Instantiates a new Game level.
     *
     * @param animationRunner  the animation runner
     * @param levelInformation the level information
     * @param lives            the lives
     * @param score            the score
     */
    public GameLevel(AnimationRunner animationRunner, LevelInformation levelInformation, Counter lives, Counter score) {
        this.runner = animationRunner;
        this.levelInformation = levelInformation;
        this.lives = lives;
        this.score = score;
    }

    /**
     * Add collidable to the list of collidables.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.getCollidables().add(c);
    }

    /**
     * Add sprite to the list of sprites.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.getListOfSprites().add(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {

        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.sprites.addSprite(this.levelInformation.getBackground());

        //Creates counters of the game:counter of blocks,balls and scores
        this.counterOfBlocks = new Counter(this.levelInformation.numberOfBlocksToRemove());
        this.counterOfBalls = new Counter(0);

        //Creates block and ball removers
        BlockRemover blockRemover = new BlockRemover(this, this.counterOfBlocks);
        BallRemover ballRemover = new BallRemover(this, this.counterOfBalls);

        //Creates ScoreTrackingListener and ScoreIndicator
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        GameIndicator gameIndicator = new GameIndicator(this.levelInformation.levelName());
        LiveIndicator liveIndicator = new LiveIndicator(this.lives);

        this.sprites.addSprite(scoreIndicator);
        this.sprites.addSprite(gameIndicator);
        this.sprites.addSprite(liveIndicator);

        //Additional top block
        Block topBlockAdditional = new Block(new Rectangle(new Point(0, 0), 800, 1), Color.GRAY, 0);
        topBlockAdditional.addToGame(this);
        topBlockAdditional.addHitListener(ballRemover);
        //Additional right block
        Block rightBlockAdditional = new Block(new Rectangle(new Point(0, 0), 1, 600), Color.GRAY, 0);
        rightBlockAdditional.addToGame(this);
        rightBlockAdditional.addHitListener(ballRemover);
        //Additional left block
        Block leftBlockAdditional = new Block(new Rectangle(new Point(799, 0), 1, 600), Color.GRAY, 0);
        leftBlockAdditional.addToGame(this);
        leftBlockAdditional.addHitListener(ballRemover);


        //left block of the frame
        Block leftBlock = new Block(new Rectangle(new Point(0, 25), 25, 600), Color.GRAY, 0);
        leftBlock.addToGame(this);
        //right block of the frame
        Block rightBlock = new Block(new Rectangle(new Point(775, 25), 25, 600), Color.GRAY, 0);
        rightBlock.addToGame(this);
        //upper block of the frame
        Block topBlock = new Block(new Rectangle(new Point(0, 25), 800, 25), Color.GRAY, 0);
        topBlock.addToGame(this);
        //lower block of the frame
        Block bottomBlock = new Block(new Rectangle(new Point(25, 599), 750, 25), Color.RED, 0);
        bottomBlock.addToGame(this);
        bottomBlock.addHitListener(ballRemover);

        for (Block b: this.levelInformation.blocks()) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
        }


    }


    /**
     * Removes a collidable from the list of collidables.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {

        this.environment.getCollidables().remove(c);
    }

    /**
     * Removes a sprite from the list of sprites.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.getListOfSprites().remove(s);
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        //Displays the sprites and notifies them time has passed
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        //Checks if the player pressed 'p' for pause
        if (runner.getKeyboardSensor().isPressed("p")) {
            PauseScreen pauseScreen = new PauseScreen();
            KeyPressStoppableAnimation keyPressStoppableAnimation =
                    new KeyPressStoppableAnimation(this.runner.getKeyboardSensor(),
                            KeyboardSensor.SPACE_KEY, pauseScreen);
            this.runner.run(keyPressStoppableAnimation);
        }
        //Checks if the counter of blocks is 0-adds to score counter 100 points and updates the running to 'false'
        if (this.counterOfBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        //Checks if the counter of balls is 0-decrease 1 live and updates the running to 'false'
        if (this.counterOfBalls.getValue() == 0) {
            this.lives.decrease(1);
            this.running = false;
        }


    }

    /**
     * Runs the game -- starts the animation loop.
     */
    public void run() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * Create balls on top of paddle.
     */
    public void createBallsOnTopOfPaddle() {
        if (this.paddle != null) {
            this.paddle.removePaddle(this);
        }
        paddle = new Paddle(this.runner.getKeyboardSensor(), levelInformation.paddleWidth());
        paddle.addToGame(this);
        List<Velocity> velocityList = levelInformation.initialBallVelocities();
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            this.counterOfBalls.increase(1);
            Ball ball = new Ball(new Point(400, 500), 5, Color.WHITE);
            ball.setGameEnvironment(this.environment);
            ball.setVelocity(velocityList.get(i));
            ball.addToGame(this);
        }

    }

    /**
     * Returns number of balls.
     *
     * @return the number of balls
     */
    public int getCounterOfBalls() {
        return this.counterOfBalls.getValue();
    }


    /**
     * Returns number of blocks.
     *
     * @return the number of blocks
     */
    public int getCounterOfBlocks() {
        return this.counterOfBlocks.getValue();
    }


}