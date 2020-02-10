package Dijkstra.Program.View.Tests;

import static org.junit.jupiter.api.Assertions.*;

import Dijkstra.Program.View.PaintingTools;
import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.Node;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.MouseEvent;

class PaintingToolsTest {

    @Test
    void isWithinBoundsEQTrue() {
        Button button = new Button();

        assertTrue(PaintingTools.isWithinBounds(new MouseEvent(button, 0, 0, 0, 0, 0, 0, true), new Point(5, 5)));
    }

    @Test
    void isWithinBoundsEQFalse() {
        Button button = new Button();

        assertFalse(PaintingTools.isWithinBounds(new MouseEvent(button, 0, 0, 0, 55, 55, 0, true), new Point(0, 0)));
    }

    @Test
    void isOverlappingEQTrue() {
        Button button = new Button();

        assertTrue(PaintingTools.isOverlapping(new MouseEvent(button, 0, 0, 0, 0, 0, 0, true), new Point(5, 5)));
    }

    @Test
    void isOverlappingEQFalse() {
        Button button = new Button();

        assertFalse(PaintingTools.isOverlapping(new MouseEvent(button, 0, 0, 0, 555, 555, 0, true), new Point(0, 0)));
    }

    @Test
    void isOnEdgeEQTrue() {
        Button button = new Button();
        Point point = new Point();
        Node firstNode = new Node(point);
        Node secondNode = new Node(point);
        Edge edge = new Edge(firstNode, secondNode);

        assertTrue(PaintingTools.isOnEdge(new MouseEvent(button, 0, 0, 0, 0, 0, 0, true), edge));
    }

    @Test
    void isOnEdgeEQFalse() {
        Button button = new Button();
        Point point = new Point();
        Node firstNode = new Node(point);
        Node secondNode = new Node(point);
        Edge edge = new Edge(firstNode, secondNode);

        assertFalse(PaintingTools.isOnEdge(new MouseEvent(button, 0, 0, 0, 66, 66, 0, true), edge));
    }
}