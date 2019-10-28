package com.adiwang;

import com.adiwang.examples.In;

public class NBody {

    public double readRadius(String fileName){
        In in = new In(fileName);
        int numOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static void main(String[] args) {
        String dir = "planets.txt";
        NBody n = new NBody();
        System.out.println(n.readRadius(dir));
    }
}
