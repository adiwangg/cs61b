package disc3;

public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList(int x){
        first = new IntNode(x, null);
    }

    public void addFirst(int x){
        first = new IntNode(x,first);
    }

    public int get(int x){
        IntNode ptr = this.first;
        for (int i = 0; i < x; i++){
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public void insert(int item, int position){
        IntNode ptr = first;
        for(int i = 0; i < position-1; i++){
            if(ptr.next==null){
                break;
            }
            ptr = ptr.next;
        }
        ptr.next = new IntNode(item,ptr.next);
    }

    public void insertSol(int item, int position){
        if(first == null || position == 0){
            addFirst(item);
            return;
        }

        IntNode currentNode = first;
        while(position > 1 && currentNode.next != null){
            position --;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }

    /** a method to reverse the elements in SLList(iteratively) */
    public void reverseSol(){
        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = first;
        while (nextNodeToAdd != null) {
            IntNode remainderOfOriginal = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = remainderOfOriginal;
            }
        first = frontOfReversed;
    }

    /** reverse the elements by recursion */
    public void reverse() {
        first = reverseRecursiveHelper(first);
    }

    private IntNode reverseRecursiveHelper(IntNode front){
        if (front == null || front.next == null) {
            return front;
        } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }


    public static void main(String[] args) {
        SLList L = new SLList(3);
        L.addFirst(2);
        L.addFirst(1);
//        L.insert(20,10);
        L.reverse();
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));

    }
}
