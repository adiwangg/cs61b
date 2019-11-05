public class SLList<T> {
	
	/* Nested class */
	public class IntNode {
		public T item;
		public IntNode next;
		
		public IntNode(T i, IntNode n) {
			item = i;
			next = n;	
		}
	}
	
	private IntNode sentinal;
	private int size;

	public SLList() {
		sentinal = new IntNode(null,null);
		size = 0;
	}

	public SLList(T x) {
		sentinal = new IntNode(null,null);
		sentinal.next = new IntNode(x,null);
		size = 1;
	}
	
	/** Adds x to the front of the list */
	public void addFirst(T x) {
		sentinal.next = new IntNode(x,sentinal.next);
		size++;
	}

	/** Adds x to the end of the list */
	public void addLast(T x) {
			IntNode p = sentinal;
			/* Move p until it reaches the end of the list */
			while(p.next!=null) {
				p = p.next;
			}
			p.next = new IntNode(x,null);
			size++;
	}
	
	/** Retrieves the front item from the list */
	public T getFirst() {
		return sentinal.next.item;
	}
	
	public int size() {
		return size;
	}

	public T get(int index) {
		IntNode ptr = sentinal;
		for (int i = 0; i < size; i++) {
			ptr = ptr.next;
		}
		return ptr.item;
	}

	public void printList() {
		IntNode ptr = sentinal.next;
		for (int i = 0; i < size; i++) {
			System.out.print(ptr.item + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SLList<String> list = new SLList<>();
		list.addLast("hello");
		list.addLast("world");
		list.addLast("Dylan");
		list.addFirst("welcome");

		list.printList();
		System.out.println(WordUtils.findLongestString(list));
	}
}
