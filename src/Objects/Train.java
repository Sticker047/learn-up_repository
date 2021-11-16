package Objects;

public class Train
{
    private int countOfWagons;
    private String typeOfTrain;
    private String country;

    private Wagon[] wagons;

    public Train(int countOfWagons, String typeOfTrain, String country) {
        this.countOfWagons = countOfWagons;
        this.typeOfTrain = typeOfTrain;
        this.country = country;
    }

    public Train()
    {
        this.countOfWagons = (int)(2 + Math.round(Math.random() * 50));
        String[] types = new String[]{"Высокоскоростной", "Скоростной", "Скорый"};
        this.typeOfTrain = types[(int)Math.round(Math.random() * (types.length - 1))];
        String[] countries = new String[]{"Франция", "Россия", "США", "Германия", "Китай"};
        country = countries[(int)Math.round(Math.random() * (countries.length - 1))];
        wagons = new Wagon[(int)Math.round(2 + Math.random() * 20)];

        for (int i = 0; i < wagons.length; i++)
            wagons[i] = new Wagon();
    }

    public Wagon[] getWagons() {
        return wagons;
    }

    @Override
    public String toString()
    {
        return "\nЧисло вагонов: " + countOfWagons +
                "\nТип поезда: " + typeOfTrain +
                "\nСтрана: " + country;
    }
}
