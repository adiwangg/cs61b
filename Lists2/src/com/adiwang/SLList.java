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
	
	private IntNode sentinal;
	private int size;

	public SLList() {
		sentinal = new IntNode(66,null);
		size = 0;
	}

	public SLList(int x) {
		sentinal = new IntNode(66,null);
		sentinal.next = new IntNode(x,null);
		size = 1;
	}
	
	
	/** Adds x to the front of the list */
	public void addFirst(int x) {
		sentinal.next = new IntNode(x,sentinal.next);
		size++;
	}

	/** Adds x to the end of the list */
	public void addLast(int x) {

			IntNode p = sentinal;
			
			/* Move p until it reaches the end of the list */
			while(p.next!=null) {
				p = p.next;
			}
			p.next = new IntNode(x,null);
			size++;
		
	}
	
	/** Retrieves the front item from the list */
	public int getFirst() {
		return sentinal.next.item;
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		SLList L = new SLList();
		L.addLast(20);
		
		System.out.println(L.size());

	}
}
