/**
 * The HitNotifier interface indicates that objects that implement it send notifications when they are being hit.
 */
public interface HitNotifier {
    /**
     * Adds the HitListener 'hl' as a listener to hit events.
     *
     * @param hl the hit listener
     */

    void addHitListener(HitListener hl);

    /**
     * Removes the HitListener 'hl' from the list of listeners to hit events.
     *
     * @param hl the hit listener
     */
    void removeHitListener(HitListener hl);
}
