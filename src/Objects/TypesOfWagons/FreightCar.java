package Objects.TypesOfWagons;

import Objects.Wagon;

public class FreightCar extends Wagon {
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

}
