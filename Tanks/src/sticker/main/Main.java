package sticker.main;

import sticker.display.Display;
import sticker.game.Game;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {

        Game tanks = new Game();
        tanks.start();

    }
}