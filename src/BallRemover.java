//ID: 324488287
/**
 * BallRemover is a HitListener that will be in charge of removing balls, and updating an available-balls counter.
 *
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks counter
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //The hitter ball removes itself from the game
        hitter.removeFromGame(this.game);
        //Updates the remaining balls counter
        this.remainingBalls.decrease(1);
    }

}
