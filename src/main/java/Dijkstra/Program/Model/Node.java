package Dijkstra.Program.Model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;

import java.awt.*;

@Getter
@Setter
public class Node implements ModelConstants {

    private Point point;
    private int identifier;
    private java.util.List<Node> nodeList;

    @Contract(pure = true)
    public Node(Point point) {
        this.point = point;
    }

   public void setPoint(int x, int y) {
        point.setLocation(x, y);
    }

    public int getX() {
        return (int) point.getX();
    }

    public int getY() {
        return (int) point.getY();
    }
}
