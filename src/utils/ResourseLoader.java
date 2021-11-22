package utils;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourseLoader {

    public static final String path = "res/";

    public static BufferedImage loadImage(String fileName) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

}
