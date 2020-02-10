package Dijkstra.Program.Model.Tests;

import Dijkstra.Program.Model.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node node;
    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point();
        node = new Node(point);
    }

    @AfterEach
    void tearDown() {
        node = null;
        point = null;
    }

    @Test
    void setIdentifierFromZeroPositiveSet() {
        int[] identifier = {0, 1, 3, 5, 99, 123, 55512, 99446, Integer.MAX_VALUE};

        for (int value : identifier) {
            node.setIdentifier(value);
            assertEquals(value, node.getIdentifier());
        }
    }

    @Test
    void setIdentifierFromNegativeSet() {
        int[] identifier = {-1, -3, -5, -99, -123, -55512, -99446, Integer.MIN_VALUE};

        for (int value : identifier) {
            node.setIdentifier(value);
            assertEquals(value, node.getIdentifier());
        }
    }

    @Test
    void setPointXPositiveValue() {
        int[] XValue = {0, 1, 4124, 5145, 12499, 13, 54152, 124546, Integer.MAX_VALUE};

        for (int value : XValue) {
            node.setPoint(value, 0);
            assertEquals(value, node.getX());
        }
    }

    @Test
    void setPointXNegativeValue() {
        int[] XValue = {-1, -4124, -5145, -12499, -13, -54152, -124546, Integer.MIN_VALUE};

        for (int value : XValue) {
            node.setPoint(value, 0);
            assertEquals(value, node.getX());
        }
    }

    @Test
    void setPointYPositiveValue() {
        int[] YValue = {0, 1, 4124, 5145, 12499, 13, 54152, 124546, Integer.MAX_VALUE};

        for (int value : YValue) {
            node.setPoint(0, value);
            assertEquals(value, node.getY());
        }
    }

    @Test
    void setPointYNegativeValue() {
        int[] YValue = {-1, -4124, -5145, -12499, -13, -54152, -124546, Integer.MIN_VALUE};

        for (int value : YValue) {
            node.setPoint(0, value);
            assertEquals(value, node.getY());
        }
    }

    @Test
    void getPoint() {
        assertEquals(point, node.getPoint());
    }

    @Test
    void setNodeList() {
        ArrayList<Node> nodeList = new java.util.ArrayList<>();

        node.setNodeList(nodeList);

        assertEquals(nodeList, node.getNodeList());
    }

    @Test
    void getNodeList() {
        ArrayList<Node> nodeList = new java.util.ArrayList<>();

        node.setNodeList(nodeList);
    }

    @Test
    void getX() {
        point.setLocation(-5,5);

        assertEquals(-5, point.getX());
    }

    @Test
    void getY() {
        point.setLocation(-5,5);

        assertEquals(5, point.getY());
    }

    @Test
    void getIdentifier() {
        assertEquals(0, node.getIdentifier());
    }
}