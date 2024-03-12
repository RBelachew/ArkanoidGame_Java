//ID: 324488287
/**
 * A BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks counter
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //Removes the beingHit block if the number that appears on it is zero
        if (beingHit.getHitPoint() == 0) {
            beingHit.removeFromGame(this.game);
            //Updates the remaining blocks counter
            this.remainingBlocks.decrease(1);
        }
    }
}