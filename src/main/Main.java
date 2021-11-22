package main;

import entities.Program;
import objects.Train;
import objects.Wagon;

public class Main {

    public static final int HEIGHT = 800;
    public static final int WIDTH = 600;
    public static void main(String[] args) {

        Program program = new Program();
        program.start();

//        Train train = new Train();
//
//        printTrain(train);

    }

    public static void printTrain(Train train)
    {
        System.out.println(train);

        for (Wagon wagon : train.getWagons()) {
            System.out.println(wagon.toString());
        }
    }

}
