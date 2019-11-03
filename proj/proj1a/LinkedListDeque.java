public class LinkedListDeque<T> {

    public class TNode {
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(T i, TNode p, TNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private TNode sentinel;

    public LinkedListDeque() {
        sentinel = new TNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new TNode(item,sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, seperated by a space */
    public void printDeque() {
        TNode ptr = sentinel;
        while (ptr.next!=sentinel) {
            ptr = ptr.next;
            System.out.print(ptr.item);
            System.out.print(" ");
        }
        System.out.println("");

    }

    /** Removes and returns the item at the front of the deque */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        TNode first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }

    /** Removes and returns the item at the back of the deque */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        TNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    public T get(int index) {
        if (index > size - 1) {
            index = size - 1;
        }
        TNode ptr = sentinel.next;
        for(int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        return null;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> deque = new LinkedListDeque<>();
        deque.addFirst("hello");
        deque.addFirst("world,");
        deque.addLast("Dylan!");
//        deque.removeFirst();
//        deque.removeLast();
        deque.printDeque();
        System.out.println(deque.get(5));
        System.out.println(deque.get(0));
    }

}
