package Dijkstra.Program.View;

import lombok.Getter;

import javax.swing.*;

@Getter
public class Initializer implements ViewConstants {

    private JFrame jFrame;
    private boolean visible;

    public Initializer(){
        jFrame = new JFrame();
        visible = true;
    }

    public void start(){
        jFrame.setTitle(ViewConstants.TITLE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.add(new MainWindow());
        jFrame.setVisible(visible);
    }
}
