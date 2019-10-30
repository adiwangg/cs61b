import java.util.Scanner;

public class NBody {

    public static double readRadius(String dir) {
        In in = new In(dir);

        int numOfPlanets = in.readInt();
        double R = in.readDouble();
        return R;
    }

//    public static int calcNumOfPlanets(String dir){
//        In in = new In(dir);
//        int num = 0;
//
//        while (in.hasNextLine()){
//            num += 0;
//        }
//        return (num - 2);
//    }

    public static Planet[] readPlanets(String dir){
        In in = new In(dir);

        int numOfPlanets = in.readInt();
        double r = in.readDouble();
        Planet[] planets = new Planet[numOfPlanets];

        for(int i = 0; i < numOfPlanets; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP,yP,xV,yV,m,img);
        }

        return planets;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the T:");
        double T = sc.nextDouble();
        System.out.println("Please enter the dt:");
        double dt = sc.nextDouble();
        System.out.println("Please enter the filename:");
        String filename = sc.nextLine();

        String dir = "./data/planets.txt";
        double r = NBody.readRadius(dir);
        Planet[] planets = NBody.readPlanets(dir);



    }
}
