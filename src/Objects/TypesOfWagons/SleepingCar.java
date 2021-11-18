package Objects.TypesOfWagons;

public class SleepingCar extends Coach {
    protected String type = "Спальный вагон";

    public SleepingCar() {
        super();
        priceOfTicket = 5500 + (int)Math.round(Math.random() * 300000) / 100; // 5500 <= pot <= 8500
    }
}
