package Objects.TypesOfWagons;

public class CompartmentCarriage extends Coach {

    protected String type = "Купейный вагон";

    public CompartmentCarriage() {
        super();
        priceOfTicket = 1500 + (int)Math.round(Math.random() * 300000) / 100; // 1500 <= pot <= 4500
    }
}
