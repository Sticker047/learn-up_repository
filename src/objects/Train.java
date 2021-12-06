package objects;

import IO.Input;
import entities.Entity;
import entities.EntityType;
import entities.Refueled;
import graphics.Sprite;
import graphics.SpriteSheet;
import graphics.TextureAtlas;
import objects.typesOfWagons.*;
import utils.IncorrectInputDataException;
import utils.RefuelException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Train extends Entity implements Refueled {

    public static final int SPRITE_SCALE = 16;
    public static final int SPRITES_PER_HEADING = 1;

    public float fuel;
    public static final float MAX_FUEL = 1000;

    public static final int MIN_COUNT_WAGON = 6;
    public static final int MAX_COUNT_WAGON = 12;

    @Override
    public void refuel(float litres) throws RefuelException
    {
        if (fuel + litres > MAX_FUEL) fuel = MAX_FUEL;
        else if (litres < 0) throw new RefuelException(litres);
        else fuel += litres;
    }

    @Override
    public void drainFuel() {
        fuel = 0;
    }

    private enum Heading {
        CompartmentCarriage(0, 0, 60, 300);

        private int x, y, h, w;

        Heading(int x, int y, int h, int w) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
        }

        protected BufferedImage texture(TextureAtlas atlas) {
            return atlas.cut(x, y, w, h);
        }
    }

    private Heading heading;
    private Map<Heading, Sprite> spriteMap;
    private float scale;
    private float speed;

    private int countOfWagons;
    private TypeOfTrain typeOfTrain;

    private Wagon[] wagons;

    public Train(int countOfWagons, TypeOfTrain typeOfTrain) {
        if (countOfWagons < MIN_COUNT_WAGON || countOfWagons > MAX_COUNT_WAGON)
            throw new IncorrectInputDataException(MIN_COUNT_WAGON, MAX_COUNT_WAGON);
        this.countOfWagons = countOfWagons;
        this.typeOfTrain = typeOfTrain;
    }

    public Train(float x, float y, float scale, float speed, TextureAtlas atlas) {
        super(EntityType.Train, x, y);

        fuel = 0;
        heading = Heading.CompartmentCarriage;
        spriteMap = new HashMap<Heading, Sprite>();
        this.scale = scale;
        this.speed = speed;

        for (Heading h : Heading.values()) {
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas), SPRITES_PER_HEADING, SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet, scale);
            spriteMap.put(heading, sprite);

            this.countOfWagons = (int) (6 + Math.round(Math.random() * 6));
            TypeOfTrain[] types = TypeOfTrain.values();
            this.typeOfTrain = types[(int) Math.round(Math.random() * (types.length - 1))];

            wagons = new Wagon[(int) Math.round(MIN_COUNT_WAGON + Math.random() * 6)];
            for (int i = 0; i < wagons.length; i++)
                wagons[i] = createRandomWagonOrNullIfException();
        }
    }

    public Wagon[] getWagons() {
        return wagons;
    }

    @Override
    public String toString() {
        return "\nЧисло вагонов: " + countOfWagons +
                "\nТип поезда: " + typeOfTrain;
    }

    public Wagon createRandomWagonOrNullIfException() {
        int rnd = (int) Math.round(Math.random() * 4);

        boolean created = false;
        Wagon wagon;
        switch (rnd) {
            case 0: {
                wagon = new Coach();
                return wagon;
            }
            case 1: {
                wagon = new CompartmentCarriage();
                return wagon;
            }
            case 2: {
                wagon = new EconomClassTrain();
                return wagon;
            }
            case 3: {
                wagon = new FreightCar();
                return wagon;
            }
            case 4: {
                wagon = new SleepingCar();
                return wagon;
            }
            default: {
            }
        }
        return null;

    }

    @Override
    public void update(Input input) {
    }

    @Override
    public void render(Graphics2D g) {
        spriteMap.get(heading).render(g, x, y);
    }
}
