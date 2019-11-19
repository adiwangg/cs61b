import edu.princeton.cs.algs4.BST;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2019/11/17
 */

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;    // root of BST

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;          //number of nodes in subtree

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BSTMap() { }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) { throw new IllegalArgumentException("argument to containsKey() is null!");}
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    public V get(Node x, K key) {
        if (key == null) { throw new IllegalArgumentException("Cannot get with a null key!"); }
        if (x == null) { return null; }
        int com = key.compareTo(x.key);
        if (com < 0) {
            return get(x.left,key);
        } else if(com > 0) {
            return get(x.right,key);
        } else {
            return x.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {return 0;}
        else return x.size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) { throw new IllegalArgumentException("Cannot get operate with a null key!"); }
        if (value == null) { throw new IllegalArgumentException("Cannot put null value to map!"); }
        root = put(root,key,value);
    }

    public Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int com = key.compareTo(x.key);
        if (com < 0) {
            x.left = put(x.left, key, value);
        } else if (com > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        keySet(root, set);
        return set;
    }

    // helper
    public void keySet(Node x, Set<K> s) {
        if (x == null) {
            return;
        }
        s.add(x.key);
        keySet(x.left,s);
        keySet(x.right,s);
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        BSTMap<Integer,String> map = new BSTMap<>();
        map.put(5,"hello");
        map.put(3,"hi");
        map.put(2,"dylan");
        map.put(6,"tom");
        map.put(1,"peter");
        System.out.println(map.keySet());
    }
}
