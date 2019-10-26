package com.adiwang;

public class SLList {
	
	/* Nested class */
	public class IntNode {
		public int item;
		public IntNode next;
		
		public IntNode(int i, IntNode n) {
			item = i;
			next = n;	
		}
	}
	
	private IntNode first;
	private int size;
	
	public SLList(int x) {
		first = new IntNode(x,null);
		size = 1;
	}
	
	public SLList() {
		first = null;
		size = 0;
	}
	
	
	/** Adds x to the front of the list */
	public void addFirst(int x) {
		first = new IntNode(x,first);
		size++;
	}
	
	/** Adds x to the end of the list */
	public void addLast(int x) {
		
		if(first!=null) {
			IntNode p = first;
			
			/* Move p until it reaches the end of the list */
			while(p.next!=null) {
				p = p.next;
			}
			p.next = new IntNode(x,null);
			size++;
		}else {
			addFirst(x);
		}
		
	}
	
	/** Retrieves the front item from the list */
	public int getFirst() {
		return first.item;
	}
	
	public int size() {
		return size;
	}

	
	public static void main(String[] args) {
		SLList L = new SLList();
		L.addLast(20);
		
		System.out.println(L.size());
		System.out.println("updated from win!");

	}

}
