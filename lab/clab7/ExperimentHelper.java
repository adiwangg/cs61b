/**
 * Created by hug.
 */
public class ExperimentHelper {

    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    public static int optimalIPL(int N) {
        int res = 0;
        int temp = N;
        int count = 0;
        while (temp != 1) {
            count++;
            temp = temp/2;
        }
        for (int i = 0; i < count; i++) {
            res += Math.pow(2,i) * i;
        }
        res += (N - Math.pow(2,count) - 1) * count;

        return res;
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */
    public static double optimalAverageDepth(int N) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(ExperimentHelper.optimalIPL(7));
    }
}
