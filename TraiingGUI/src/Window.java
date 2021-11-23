import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window()
    {
        super("Snake");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.green);

        Snake snake = new Snake();

        synchronized (this) {
            Runnable task = () -> {
                while (snake.getDirection() == Direction.RIGHT) {
                    try {
                        wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                getContentPane().removeAll();
                snake.movingRight();
                panel.add(snake.getJp());
                getContentPane().add(panel);
            };

            Thread thread = new Thread(task);
            thread.start();
        }

//        panel.add(snake.getJp());

//        getContentPane().add(panel);

        setPreferredSize(new Dimension(500, 500));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                Window frame = new Window();
                frame.pack();
                frame.setLayout(null);
                frame.setLocationRelativeTo(null);//Окно появляется в центре экрана
//                frame.setLocation(100, 100);//Задаёт координаты окна
                frame.setVisible(true);
            }
        });
    }
}
