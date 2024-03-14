import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation is a decorator-class that will wrap an existing animation and add a
 * "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop = false;
    private boolean isAlreadyPressed = true;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        //Verifies that the key press started only after the animation started
        if (isAlreadyPressed) {
            if (!this.sensor.isPressed(key)) {
                isAlreadyPressed = false;
            }
            return;
        }
        if (this.sensor.isPressed(key)) {
            stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
