package main;

import entities.Program;
import objects.Train;
import objects.TypeOfTrain;
import objects.Wagon;
import utils.IncorrectInputDataException;
import utils.RefuelException;

public class Main {

    public static void main(String[] args) {

//        Program program = new Program();
//        program.start();

        try {
            Train train = new Train(-5, TypeOfTrain.ВЫСОКОСКОРОСТНОЙ);
        } catch (IncorrectInputDataException e) {
            e.printStackTrace();
        } finally {
            try {
                Train train2 = new Train(8, TypeOfTrain.СКОРЫЙ);
                train2.refuel(-2.0f);
            } catch (RefuelException ex) {
                ex.printStackTrace();
            }


        }
    }


    public static void printTrain(Train train) {
        System.out.println(train);

        for (Wagon wagon : train.getWagons()) {
            System.out.println(wagon.toString());
        }
    }

}
