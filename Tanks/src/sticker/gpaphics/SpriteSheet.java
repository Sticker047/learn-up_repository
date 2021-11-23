package sticker.gpaphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    private int spriteCount;
    private int scale;
    private int spritesInWidth;

    public SpriteSheet(BufferedImage sheet, int spriteCount, int scale) {
        this.sheet = sheet;
        this.spriteCount = spriteCount;
        this.scale = scale;

        this.spritesInWidth = sheet.getWidth() / scale;

    }

    public BufferedImage getSprite(int index) {

        index = index % spriteCount;

        int x = index % spritesInWidth;
        int y = index / spritesInWidth;

        return sheet.getSubimage(x, y, scale, scale);
    }

}
