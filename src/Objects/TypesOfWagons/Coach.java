package Objects.TypesOfWagons;

import Objects.Wagon;

public class Coach extends Wagon {
    protected String type = "Пассажирский вагон";

    protected int priceOfTicket;

    public Coach() {
        super();
        priceOfTicket = 500 + (int)Math.round(Math.random() * 300000) / 100; // 500 <= pot <= 3500
    }

    @Override
    public String toString() {
        return type + "\n" + super.toString()
                + "\nСтоимость билета: " + priceOfTicket + ".00р";
    }

}
