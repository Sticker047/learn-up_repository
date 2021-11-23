package sticker.game;

import sticker.IO.Input;

import java.awt.*;

public abstract class Entity {

    public final EntityType type;

    protected float x;
    protected float y;

    protected Entity(EntityType entityType, float x, float y) {
        this.type = entityType;
        this.x = x;
        this.y = y;

    }

    public abstract void update(Input input);

    public abstract void render(Graphics2D g);

}
