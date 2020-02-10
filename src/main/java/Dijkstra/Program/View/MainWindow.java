package Dijkstra.Program.View;

import Dijkstra.Program.Controller.DijkstraAlgorithm;
import Dijkstra.Program.Model.GraphLogic;
import org.jetbrains.annotations.NotNull;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class MainWindow extends JPanel {

    private GraphLogic graphLogic;
    private MouseInteractions mouseInteractions;

    MainWindow(){
        super.setLayout(new BorderLayout());
        setGraphPanel();
    }

    private void setGraphPanel(){
        graphLogic = new GraphLogic();
        mouseInteractions = new MouseInteractions(graphLogic);
        mouseInteractions.setPreferredSize(new Dimension(9000, 4096));

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(mouseInteractions);
        scroll.setPreferredSize(new Dimension(750, 500));
        scroll.getViewport().setViewPosition(new Point(4100, 0));
        add(scroll, BorderLayout.CENTER);
        setButtons();
    }

    private void setButtons(){
        JButton run = new JButton();
        setupIcon(run, "start");
        JButton reset = new JButton();
        setupIcon(reset, "clear");
        final JButton info = new JButton();
        setupIcon(info, "information");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(PaintingTools.parseColor("#DDDDDD"));
        buttonPanel.add(reset);
        buttonPanel.add(run);
        buttonPanel.add(info);

        reset.addActionListener(e -> mouseInteractions.reset());

        info.addActionListener(e -> JOptionPane.showMessageDialog(null, ViewConstants.SHOW_MESSAGE));

        run.addActionListener(e -> {
            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graphLogic);
            try{
                dijkstraAlgorithm.run();
                mouseInteractions.setPath(dijkstraAlgorithm.getDestinationPath());
            } catch (IllegalStateException ise){
                JOptionPane.showMessageDialog(null, ise.getMessage());
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupIcon(@NotNull JButton button, String img){
        try {
            Image icon = ImageIO.read(new File("C:/Users/dol/IdeaProjects/Diploma/src/main/java/Dijkstra/resources/" + img + ".png"));
            ImageIcon imageIcon = new ImageIcon(icon);
            button.setIcon(imageIcon);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
