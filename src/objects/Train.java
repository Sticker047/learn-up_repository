package objects;

import IO.Input;
import entities.Entity;
import entities.EntityType;
import graphics.Sprite;
import graphics.SpriteSheet;
import graphics.TextureAtlas;
import objects.typesOfWagons.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Train extends Entity {

    public static final int SPRITE_SCALE = 16;
    public static final int SPRITES_PER_HEADING = 1;

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
    private String typeOfTrain;

    private Wagon[] wagons;

    public Train(int countOfWagons, String typeOfTrain) {
        this.countOfWagons = countOfWagons;
        this.typeOfTrain = typeOfTrain;
    }

    public Train(float x, float y, float scale, float speed, TextureAtlas atlas){
        super(EntityType.Train, x, y);

        heading = Heading.CompartmentCarriage;
        spriteMap = new HashMap<Heading, Sprite>();
        this.scale = scale;
        this.speed = speed;

        for (Heading h : Heading.values()){
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas), SPRITES_PER_HEADING, SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet, scale);
            spriteMap.put(heading, sprite);

            this.countOfWagons = (int) (6 + Math.round(Math.random() * 6));
            String[] types = new String[]{"Высокоскоростной", "Скоростной", "Скорый"};
            this.typeOfTrain = types[(int) Math.round(Math.random() * (types.length - 1))];

            wagons = new Wagon[(int) Math.round(6 + Math.random() * 6)];
            for (int i = 0; i < wagons.length; i++)
                wagons[i] = createRandomWagon();
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

    public Wagon createRandomWagon() {
        int rnd = (int) Math.round(Math.random() * 4);

        Wagon wagon;
        switch (rnd) {
            case 0: {
                wagon = new Coach();
            }
            break;
            case 1: {
                wagon = new CompartmentCarriage();
            }
            break;
            case 2: {
                wagon = new EconomClassTrain();
            }
            break;
            case 3: {
                wagon = new FreightCar();
            }
            break;
            case 4: {
                wagon = new SleepingCar();
            }
            break;
            default: {
                wagon = new Wagon();
            }
        }

        return wagon;
    }

    @Override
    public void update(Input input) {
    }

    @Override
    public void render(Graphics2D g) {
        spriteMap.get(heading).render(g, x, y);
    }
}
