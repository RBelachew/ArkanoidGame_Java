import biuoop.KeyboardSensor;

import java.util.List;

/**
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private Counter lives;
    private Counter score;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the AnimationRunner object
     */
    public GameFlow(AnimationRunner ar) {
        this.animationRunner = ar;
        this.lives = new Counter(7);
        this.score = new Counter(0);
    }

    /**
     * Runs the list of levels You gets.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo: levels) {

            GameLevel level = new GameLevel(this.animationRunner, levelInfo, this.lives, this.score);
            //Initializes the level
            level.initialize();

            //As long as the level has blocks and lives run the level
            while ((level.getCounterOfBlocks() > 0) && (this.lives.getValue() > 0)) {
                level.run();
            }
            //If there is no more lives-break
            if (this.lives.getValue() == 0) {
                break;
            }

        }
        HighScore highScore=new HighScore();
        if(this.score.getValue()>highScore.readHighScore()){
            highScore.wrightHighScore(this.score.getValue());
        }
        //Represents the results of the game
        EndScreen endScreen;
        if (this.lives.getValue() == 0) {
            endScreen = new EndScreen("Game Over. Your score is " + this.score.getValue());
        } else {
            endScreen = new EndScreen("You Win! Your score is " + this.score.getValue());
        }

        KeyPressStoppableAnimation keyPressStoppableAnimation =
                new KeyPressStoppableAnimation(this.animationRunner.getKeyboardSensor(),
                        KeyboardSensor.SPACE_KEY, endScreen);
        this.animationRunner.run(keyPressStoppableAnimation);

    }
}
