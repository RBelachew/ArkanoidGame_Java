//ID: 324488287
/**
 * Counter is a simple class that is used for counting things.
 */
public class Counter {
    private int number;

    /**
     * Instantiates a new Counter.
     *
     * @param number the number
     */
    public Counter(int number) {
        this.number = number;
    }

    /**
     * Adds a number to current count.
     *
     * @param number1 the number
     */
    public void increase(int number1) {
        this.number += number1;
    }

    /**
     * Subtracts a number from current count.
     *
     * @param number1 the number
     */
    public void decrease(int number1) {
        this.number -= number1;
    }

    /**
     * Returns current count.
     *
     * @return the value
     */
    public int getValue() {
        return this.number;
    }
}