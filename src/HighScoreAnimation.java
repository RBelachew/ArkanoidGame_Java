import biuoop.DrawSurface;

public class HighScoreAnimation implements Animation {

    @Override
    public void doOneFrame(DrawSurface d) {
        HighScore highScore=new HighScore();
        d.drawText(100,100,"The high score so far is: "+highScore.readHighScore(),50);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
