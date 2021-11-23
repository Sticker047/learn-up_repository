import javax.swing.*;
import java.awt.*;

public class Snake
{
    private JPanel jp;
    private Direction direction;
    private int X, Y;
    private final int WIDTH;
    private final int HEIGHT;

    public Snake()
    {
        X = 50;
        Y = 50;
        WIDTH = 25;
        HEIGHT = 25;

        jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.blue);
        jp.setBounds(X, Y, WIDTH, HEIGHT);
        direction = Direction.RIGHT;
    }

    public JPanel getJp() {
        return jp;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void movingRight()
    {
        if (X == 475)
            jp.setBounds(0, Y, WIDTH, HEIGHT);
        else
            jp.setBounds(X + 25, Y, WIDTH, HEIGHT);
    }
}
