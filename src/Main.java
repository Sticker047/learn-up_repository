import Objects.Train;
import Objects.TypesOfWagons.*;
import Objects.Wagon;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Train train = new Train();

        printTrain(train);

    }

    public static void printTrain(Train train)
    {
        System.out.println(train);

        for (Wagon wagon : train.getWagons()) {
            System.out.println(wagon.toString());
        }
    }

}
