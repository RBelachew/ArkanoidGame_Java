import biuoop.DrawSurface;

/**
 *  A new kind of Animation, called PauseScreen. It is a very simple animation, that will display
 *  a screen with the message 'paused -- press space to continue' until a key is pressed.
 */
public class PauseScreen implements Animation {
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(160, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
