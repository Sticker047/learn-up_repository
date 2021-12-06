package main;

import entities.Program;
import objects.Train;
import objects.Wagon;

public class Main {

    public static void main(String[] args) {

        Program program = new Program();
        program.start();

    }

    public static void printTrain(Train train)
    {
        System.out.println(train);

        for (Wagon wagon : train.getWagons()) {
            System.out.println(wagon.toString());
        }
    }

}
