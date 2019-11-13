package synthesizer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2019/11/13
 */

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    protected int fillCount;
    protected int capacity;

    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }
}