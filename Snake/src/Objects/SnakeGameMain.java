package Objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGameMain extends JPanel implements ActionListener
{
    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 10;

    Snake s = new Snake(5, 6, 5, 5);
    Apple apple = new Apple((int) (Math.random() * WIDTH - 1),
            (int) (Math.random() * HEIGHT - 1));
    Timer timer = new Timer(1000/speed,this);

    public SnakeGameMain()
    {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        for (int x = 0; x < WIDTH * SCALE; x += SCALE)
        {
            g.setColor(Color.black);
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }

        for (int y = 0; y < HEIGHT * SCALE; y += SCALE)
        {
            g.setColor(Color.black);
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        g.setColor(Color.red);
        g.fillOval(apple.posX * SCALE + 4, apple.posY * SCALE + 4, SCALE - 8, SCALE - 8);

        for (int l = 1; l < s.length; l++)
        {
            g.setColor(Color.green);
            g.fillRect(s.sX[l] * SCALE + 3, s.sY[l] * SCALE + 3, SCALE - 6, SCALE - 6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0] * SCALE + 3, s.sY[0] * SCALE + 3, SCALE - 6, SCALE - 6);
        }
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Title");
        jFrame.setSize(WIDTH * SCALE + 2, HEIGHT * SCALE + 31);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new SnakeGameMain());

//        Container container = jFrame.getContentPane();
//        JLabel jLabel = new JLabel("Длина змейки: ", JLabel.RIGHT);
//        jLabel.setPreferredSize(new Dimension(100, 25));
//        jLabel.setVerticalAlignment(JLabel.TOP);
//        jLabel.setForeground(Color.blue);
//
//        container.add(jLabel);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        s.move();
//        apple.setRandomPosition(); //Random position of apple
        if ((s.sX[0] == apple.posX) && (s.sY[0] == apple.posY))
        {
            apple.setRandomPosition();
            s.length++;
        }

        for (int l = 1; l < s.length; l++)
        {
            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY))
            {
                apple.setRandomPosition();
            }
            if ((s.sX[0] == s.sX[l]) && (s.sY[0] == s.sY[l]))
            {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Вы проиграли, начать заново?");
                jFrame.setVisible(false);
                s.length = 2;
                s.direction = 2;
                apple.setRandomPosition();
                jFrame.setVisible(true);
                timer.start();
            }
        }

        repaint();
    }

    public class KeyBoard extends KeyAdapter
    {
        public void keyPressed(KeyEvent event)
        {
            int key = event.getKeyCode();

            if((key == KeyEvent.VK_UP)  ||(key == KeyEvent.VK_W) && s.direction != 2) s.direction = 0;
            if((key == KeyEvent.VK_DOWN)  ||(key == KeyEvent.VK_S) && s.direction != 0) s.direction = 2;
            if((key == KeyEvent.VK_LEFT)  ||(key == KeyEvent.VK_A) && s.direction != 1) s.direction = 3;
            if((key == KeyEvent.VK_RIGHT)  ||(key == KeyEvent.VK_D) && s.direction != 3) s.direction = 1;
        }
    }
}
