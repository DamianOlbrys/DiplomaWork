package Dijkstra.Program.Model.Tests;

import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.Node;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    private Node firstNode;
    private Node secondNode;
    private Edge edge;

    @BeforeEach
    void setUp() {
        Point point = new Point();
        firstNode = new Node(point);
        secondNode = new Node(point);
        edge = new Edge(firstNode, secondNode);
    }

    @AfterEach
    void tearDown() {
        firstNode = null;
        secondNode = null;
        edge = null;
    }

    @Test
    void getFirstNode() {
        assertEquals(firstNode, edge.getFirstNode());
    }

    @Test
    void getSecondNode() {
        assertEquals(secondNode, edge.getSecondNode());
    }

    @Test
    void setWeightFromPositiveSet() {
        int[] weightArray = {0, 1, 234, 12343, 24, 912045, 2116, 44127, Integer.MAX_VALUE};
        int[] expectedArray = {0, 1, 234, 12343, 24, 912045, 2116, 44127, Integer.MAX_VALUE};

        for (int i = 1; i < weightArray.length; i++) {
            edge.setWeight(weightArray[i]);
            assertEquals(edge.getWeight(), expectedArray[i]);
        }
    }

    @Test
    void setWeightFromNegativeSet() {
        int[] weightArray = {-1, -231, -123312, -412512, -2312, -99999, Integer.MIN_VALUE};
        int[] expectedArray = {-1, -231, -123312, -412512, -2312, -99999, Integer.MIN_VALUE};

        for (int i = 1; i < weightArray.length; i++) {
            edge.setWeight(weightArray[i]);
            assertEquals(edge.getWeight(), expectedArray[i]);
        }
    }

    @Test
    void getWeightEqualsZero() {
        edge.setWeight(0);

        assertEquals(0, edge.getWeight());
    }

    @Test
    void isNodeEqualsWhenInitialized() {
        edge.isNode(firstNode);

        assertTrue(edge.isNode(firstNode));
    }

    @Test
    @SuppressWarnings("SimplifiableJUnitAssertion")
    void nodeEqualsFalse() {
        Edge otherEdge = new Edge(firstNode, secondNode);

        assertFalse(edge.equals(otherEdge));
    }


    @Test
    void edgeToString() {
        String edgeString = "Edge ~ 0 - 0";

        assertThat(edgeString, IsEqual.equalTo(edge.toString()));
    }
}
