package Objects;

import java.awt.*;

public class Wagon
{
    private static int count = 0;

    private int number;
    private Color color;
    private float height;
    private float width;
    private float weightOfEmpty;
    private float liftingCapacity; // Грузоподъёмность
    private String type;

    public Wagon(int number, Color color, float height, float width, float weightOfEmpty, float liftingCapacity, String type) {
        this.number = number;
        this.color = color;
        this.height = height;
        this.width = width;
        this.weightOfEmpty = weightOfEmpty;
        this.liftingCapacity = liftingCapacity;
        this.type = type;
    }

    public Wagon()
    {
        this.number = count + 1;
        count++;

        Color[] randomColors = new Color[] {Color.black, Color.white, Color.green, Color.red, Color.blue, Color.yellow};
        this.color = randomColors[(int)Math.round(Math.random() * (randomColors.length - 1))]; // 1 of 6 random colors
        this.height = (float)(4.688 + Math.round(Math.random() * 4) / 1000); // 4.688 <= h <= 4.692
        this.width = (float)(3.249 + Math.round(Math.random() * 17) / 1000); // 3.249 <= w <= 3.266
        this.weightOfEmpty = (float)(23 + Math.round(Math.random() * 3)); // 23 <= woe <= 26
        this.liftingCapacity = (float)(68 + Math.round(Math.random() * 3)); // 68 <= lc <= 71

        String[] randomTypes = new String[] {"Грузовой вагон", "Плацепртный вагон", "Купейный вагон", "Вагон люкс"};
        this.type = randomTypes[(int)Math.round(Math.random() * (randomTypes.length - 1))];
    }

    @Override
    public String toString()
    {
        String colorText = "";

        switch (color.toString())
        {
            case ("java.awt.Color[r=0,g=0,b=0]"):
            { colorText = "чёрный";}; break;
            case ("java.awt.Color[r=255,g=255,b=255]"):
            { colorText = "белый";}; break;
            case ("java.awt.Color[r=0,g=255,b=0]"):
            { colorText = "зелёный";}; break;
            case ("java.awt.Color[r=255,g=0,b=0]"):
            { colorText = "красный";}; break;
            case ("java.awt.Color[r=0,g=0,b=255]"):
            { colorText = "синий";}; break;
            case ("java.awt.Color[r=255,g=255,b=0]"):
            { colorText = "жёлтый";}; break;
        }

        return "\nНомер вагона: " + number +
                "\nЦвет вагона: " + colorText +
                "\nВысота вагона: " + height +
                "\nДлина вагона: " + width +
                "\nМасса вагона: " + weightOfEmpty +
                "\nГрузоподъемность вагона: " + liftingCapacity;
    }
}
