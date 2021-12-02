package objects.typesOfWagons;

import objects.Wagon;

public class Coach extends Wagon implements Comparable<Wagon>{
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

    @Override
    public int compareTo(Wagon o) {
        if (this.getLength() > o.getLength()) return 1;
        else if (this.getLength() < o.getLength()) return -1;
        return 0;
    }
}
