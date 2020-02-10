package Dijkstra;

import Dijkstra.Program.View.Initializer;
import javax.swing.*;

public class DijkstraMain {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.getStackTrace();
        }

        Initializer initializer = new Initializer();
        initializer.start();
    }
}
