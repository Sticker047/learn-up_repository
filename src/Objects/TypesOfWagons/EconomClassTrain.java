package Objects.TypesOfWagons;

public class EconomClassTrain extends Coach {
    protected String type = "Плацкартный вагон";

    public EconomClassTrain() {
        super();
        priceOfTicket = 500 + (int)Math.round(Math.random() * 100000) / 100; // 500 <= pot <= 1500
    }
}
