import org.w3c.dom.Node;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2019/11/26
 */

public class MyTrieSet implements TrieSet61B {

    private Node root;

    public MyTrieSet() {
        root = new Node('_', false);
    }

    private class Node {
        private char ch;
        private boolean isKey;
        private Map<Character, Node> map;
        public Node(char c, boolean b) {
            ch = c;
            isKey = b;
            map = new HashMap<>();
        }
    }

    @Override
    public void clear() {
        root = new Node('_', false);
    }

    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        if (curr.isKey == false) { return false;}
        return true;
    }

    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) {
            return;
        }
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new Node(c, false));
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        if (prefix == null || prefix.length() < 1) {
            return null;
        }
        Node curr = root;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.map.containsKey(c)) {
                return null;
            }
            curr = curr.map.get(c);
        }

        keysWithPrefixHelper(curr, res, prefix);


        return res;
    }

    public void keysWithPrefixHelper(Node curr, List<String> res, String prefix) {

        if (curr.map != null) {
            Set<Character> keySet = curr.map.keySet();
            for (char c : keySet) {
                if (contains(prefix+c)) {
                    res.add(prefix+c);
                }
                keysWithPrefixHelper(curr.map.get(c), res,prefix+c);
            }
        }
    }


    @Override
    public String longestPrefixOf(String key) {
        throw new UnsupportedOperationException();
    }
}
