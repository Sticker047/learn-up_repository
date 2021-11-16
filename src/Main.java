import Objects.Train;
import Objects.Wagon;

import java.awt.*;

public class Main
{
    public static void main(String[] args) {

        Train train = new Train();

        System.out.println(train);

        for (Wagon wagon : train.getWagons())
        {
            System.out.println(wagon.toString());
        }

//        Color[] randomColors = new Color[] {Color.black, Color.white, Color.green, Color.red, Color.blue, Color.yellow};
//        for (Color color : randomColors)
//        {
//            System.out.println(color);
//        }
    }
}
