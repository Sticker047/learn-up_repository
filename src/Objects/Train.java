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
        this.typeOfTrain = types[(int)Math.round(Math.random() * types.length)];
        String[] countries = new String[]{"Франция", "Россия", "США", "Германия", "Китай"};
        country = countries[(int)Math.round(Math.random() * countries.length)];
        wagons = new Wagon[(int)Math.round(2 + Math.random() * 20)];

        for (Wagon wagon : wagons) wagon = new Wagon();
    }
}
