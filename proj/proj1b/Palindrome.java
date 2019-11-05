public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        boolean res = true;
        while (res) {
            if (deque.size() <= 1) {
                break;
            }
            res = deque.removeFirst().equals(deque.removeLast());
        }
        return res;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        boolean res = true;
        while (res) {
            if (deque.size() <= 1) {
                break;
            }
            res = cc.equalChars(deque.removeFirst(),deque.removeLast());
        }
        return res;
    }
}
