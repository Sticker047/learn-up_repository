package entities;

import entities.MyContent;
import graphics.TextureAtlas;
import IO.Input;
import display.Window;
import objects.Train;
import utils.Time;

import java.awt.*;

public class Program implements Runnable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Поезда";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final int NUM_BUFFERS = 3;


    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
    public static final long IDLE_TIME = 1;

    public static final String ATLAS_FILE_NAME = "try1.jpg";

    private boolean running;
    private Thread programThread;
    private final Graphics2D graphics;
    private final Input input;
    //private final TextureAtlas atlas;
    private final Train train;

    public Program(){

        running = false;
        Window.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
        graphics = Window.getGraphics();
        input = new Input();
        //atlas = new TextureAtlas(ATLAS_FILE_NAME);
        train = new Train(300, 300, 2, 3, null);

    }

    public synchronized void start() {

        if (running) return;

        running = true;
        programThread = new Thread(this);
        programThread.start();
    }
    public synchronized void stop() {

        if (!running) return;

        running = false;
        try {
            programThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cleanUp();
    }

    private void update() {
    }

    private void render() {
        Window.clear();
        train.render(graphics);
        Window.swapBuffers();

    }

    public void run() {

        int fps = 0;
        int upd = 0;
        int updL = 0;

        long count = 0;

        float delta = 0;

        long lastTime = Time.get();
        while (running) {
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;

            count += elapsedTime;

            boolean render = false;
            delta += (elapsedTime / UPDATE_INTERVAL);

            while (delta > 1) {
                update();
                upd++;
                delta--;
                if (render) {
                    updL++;
                } else {
                    render = true;
                }
            }
            if (render) {
                fps++;
                render();
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count >= Time.SECOND) {
                Window.setTitle(TITLE + " || fps " + fps + " | Upd" + upd + " | updL" + updL);
                upd = 0;
                fps = 0;
                updL = 0;
                count = 0;
            }
        }
    }

    private void cleanUp() {
        Window.destroy();
    }
}
