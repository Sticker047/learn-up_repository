package objects.typesOfWagons;

import objects.Wagon;

public class FreightCar extends Wagon implements Comparable<Wagon> {
    protected String type = "Грузовой вагон";
    private float liftingCapacity; // Грузоподъёмность

    public FreightCar() {
        super();
        this.liftingCapacity = (float) (68 + Math.round(Math.random() * 3)); // 68 <= lc <= 71
    }

    @Override
    public String toString() {
        return type + "\n" + super.toString() +
                "\nГрузоподъемность вагона: " + liftingCapacity;
    }

    @Override
    public int compareTo(Wagon o) {
        if (this.getLength() > o.getLength()) return 1;
        else if (this.getLength() < o.getLength()) return -1;
        return 0;
    }
}
