import biuoop.KeyboardSensor;

public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner animationRunner;
    public ShowHiScoresTask(AnimationRunner runner) {
        this.animationRunner=runner;
    }
    public Void run() {
        this.animationRunner.run(new KeyPressStoppableAnimation(this.animationRunner.getKeyboardSensor(), KeyboardSensor.SPACE_KEY,new HighScoreAnimation()));
        return null;
    }
}