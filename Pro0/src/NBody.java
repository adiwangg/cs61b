
public class NBody {

    public static double readRadius(String dir) {
        In in = new In(dir);

        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

//    public static void main(String[] args) {
//        String dir = "planets.txt";
//        NBody n = new NBody();
//        System.out.println(n.readRadius(dir));
//    }
}
