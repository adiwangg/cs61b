
public class NBody {

    public static double readRadius(String dir) {
        In in = new In(dir);

        int numOfPlanets = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static int calcNumOfPlanets(String dir){
        In in = new In(dir);
        int num = 0;

        while (in.hasNextLine()){
            num += 0;
        }
        return (num - 2);
    }

//    public static Planet[] readPlanets(String dir){
//        In in = new In(dir);
//        int num = 0;
//
//        int numOfPlanets = in.readInt();
//        double r = in.readDouble();
//
//        while(in.hasNextLine()){
//            num += 1;
//            double xP = in.readDouble();
//            double yP = in.readDouble();
//            double xV = in.readDouble();
//            double yV = in.readDouble();
//            double m = in.readDouble();
//            String img = in.readString();
//
//        }
//
//        Planet[] planets = new Planet[num];
//
//    }

    public static void main(String[] args) {
        String dir = "./data/planets.txt";
        NBody n = new NBody();
        System.out.println(n.readRadius(dir));
        System.out.println(n.calcNumOfPlanets(dir));
    }
}
