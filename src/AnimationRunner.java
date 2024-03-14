import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * The AnimationRunner takes an Animation object and runs it. Now, we implement the task-specific information
 * in the Animation object, and run it using the loop in the AnimationRunner class.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;


    /**
     * Instantiates a new Animation runner.
     */
    public AnimationRunner() {
        this.gui = new GUI("game", 800, 600);
        this.sleeper = new Sleeper();
    }

    /**
     * It takes the task-specific information in the Animation object it gets and runs it using a loop.
     *
     * @param animation the animation object
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 60;
        //As long as the animation object doesn't stop runs the level game.
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            //doOneFrame(DrawSurface) is in charge of the logic game.
            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * Returns keyboard sensor.
     *
     * @return the keyboard sensor
     */
    public KeyboardSensor getKeyboardSensor() {
        return this.gui.getKeyboardSensor();
    }

    /**
     * Returns the gui.
     *
     * @return the gui
     */
    public GUI getGUI() {
        return this.gui;
    }
}
