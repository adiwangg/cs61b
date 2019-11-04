import java.util.Objects;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private static final int STARTSIZE = 8;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[STARTSIZE];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Minus one circularly */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** Add one circularly */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isSparse() {
        return items.length >= 16 && size < (items.length / 4);
    }

    private void upSize() {
        resize(items.length * 2);
    }

    private void downSize() {
        resize(items.length / 2);
    }

    /** Resize the deque */
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int oldFront = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            temp[i] = items[oldFront];
            oldFront = plusOne(oldFront);
        }
        items = temp;
        nextLast = size;
        nextFirst = items.length-1;
    }

    public void addFirst(T x) {
        if (isFull()) {
            upSize();
        }
        size++;
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T x) {
        if (isFull()) {
            upSize();
        }
        size++;
        items[nextLast] = x;
        nextLast = plusOne(nextLast);
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T first = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size--;
        if (isSparse()) {
            downSize();
        }
        return first;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T last = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size--;
        if (isSparse()) {
            downSize();
        }
        return last;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[index]+" ");
            index = plusOne(index);
        }
        System.out.println();
    }

    public T get(int index) {
        int currentIndex = plusOne(nextFirst);
        for(int i = 0; i < index; i++) {
            currentIndex = plusOne(currentIndex);
        }
        return items[currentIndex];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arrDeque = new ArrayDeque<>();
        arrDeque.addFirst(10);
        arrDeque.addFirst(15);
        arrDeque.addFirst(7);
        arrDeque.addFirst(41);
        arrDeque.addFirst(66);
        arrDeque.addFirst(77);
        arrDeque.addLast(100);
        arrDeque.addLast(345);
        arrDeque.addLast(23);
        arrDeque.printDeque();
        System.out.println(arrDeque.get(6));

    }

}
