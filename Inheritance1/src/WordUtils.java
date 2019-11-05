public class WordUtils {

    /** Return the index of the longest string in the list */
    public static String findLongestString(SLList<String> list) {
        int maxLength = 0;
        String longestString = null;
        if (list.size() == 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            String s = list.getFirst();
            int length = s.length();
            if (length > maxLength) {
                longestString = s;
            }
        }
        return longestString;
    }
}
