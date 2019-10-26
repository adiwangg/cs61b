package com.adiwang;

public class IntList {
	
	public int first;
	public IntList rest;
	
	public IntList(int f,IntList r) {
		first = f;
		rest = r;
	}
	
	/* Return the size of this IntList */
	public int size() {
		
		if(rest==null) {
			return 1;
		}
		return 1 + this.rest.size(); 
	}
	
	/* iterative method */
	public int get(int index) {
		IntList p = this;
		for(int i = 0;i<index;i++) {
			if(p.rest!=null) {
				p = p.rest;
			}		
		}
		return p.first;
	}
	
	public int getByRecursion(int index) {
		if(index==0) {
			return first;
		}
		return this.rest.getByRecursion(index-1);
	}
	
	/* return an IntList identical to L, but with all values incremented by x */
	public static IntList incrList(IntList L,int x) {
		
		if(L==null) {
			return null;
		}
		
		IntList newL = new IntList(L.first+x,null);
		newL.rest = incrList(L.rest,x);
		return newL;
		
	}
	
	public void addFirst(int x) {
		first = x;
		rest = new IntList(x,rest);
	}
	
	public static void main(String[] args) {
//		IntList L = new IntList(15,null);
//		L = new IntList(10,L);
//		L = new IntList(5,L);
//		
//		System.out.println(L.size());
//		System.out.println(L.get(1));
//		System.out.println(L.getByRecursion(1));
//		System.out.println(incrList(L,3).get(1));
		
		IntList L = new IntList(15,null);
		L.addFirst(10);
		System.out.println(L.get(1));
		
	}

}
