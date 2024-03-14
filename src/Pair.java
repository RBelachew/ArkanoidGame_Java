import biuoop.DrawSurface;

public class Pair<K, V> implements Animation {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public K getKey()   {
        return key;
    }
    public V getValue() {
        return value;
    }

    @Override
    public void doOneFrame(DrawSurface d) {

    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
