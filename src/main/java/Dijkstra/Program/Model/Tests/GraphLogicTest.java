package Dijkstra.Program.Model.Tests;

import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.GraphLogic;
import Dijkstra.Program.Model.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;


import static org.junit.jupiter.api.Assertions.*;

class GraphLogicTest {

    private GraphLogic graphLogic;
    private Point point;

    @BeforeEach
    void setUp() {
        graphLogic = new GraphLogic();
        point = new Point();
    }

    @AfterEach
    void tearDown() {
        graphLogic = null;
    }

    @Test
    void setSolvedEqualsTrue() {
        graphLogic.setSolved(true);

        assertTrue(graphLogic.isSolved());
    }

    @Test
    void setSolvedEqualsFalse() {
        graphLogic.setSolved(false);

        assertFalse(graphLogic.isSolved());
    }

    @Test
    void isNodeReachableWithFirstNodeEqualsFalse() {
        Node firstNode = new Node(point);

        graphLogic.addNode(point);
        assertFalse(graphLogic.isNodeReachable(firstNode));
    }

    @Test
    void isNodeReachableWithFirstNodeEqualsTrue() {
        Node firstNode = new Node(point);
        Node secondNode = new Node(point);
        Edge edge = new Edge(firstNode, secondNode);

        graphLogic.addNode(point);
        assertFalse(graphLogic.isNodeReachable(edge.getFirstNode()));
    }

    @Test
    void isNodeReachableWithSecondNodeEqualsFalse() {
        Node secondNode = new Node(point);

        graphLogic.addNode(point);
        assertFalse(graphLogic.isNodeReachable(secondNode));
    }

    @Test
    void isNodeReachableWithSecondNodeEqualsTrue() {
        Node firstNode = new Node(point);
        Node secondNode = new Node(point);
        Edge edge = new Edge(firstNode, secondNode);

        graphLogic.addNode(point);
        assertFalse(graphLogic.isNodeReachable(edge.getSecondNode()));
    }


    @Test
    void addNodeGetIdentifier() {
        Point point = new Point(0, 0);

        for (int i = 1; i < 20; i++) {
            graphLogic.addNode(point);
            assertEquals(i, graphLogic.lists.getListOfNodes().get(i - 1).getIdentifier());
        }
    }

    @Test
    void nullSourceNode() {
        assertNull(graphLogic.getSourceNode());
    }

    @Test
    void addNodeGetSourceNode() {
        Point point = new Point(0, 0);

        for (int i = 0; i < 50; i++) {
            graphLogic.addNode(point);
        }

        assertSame(graphLogic.lists.getListOfNodes().get(0), graphLogic.getSourceNode());
    }

    @Test
    void addEdge() {
        Node firstNode = new Node(point);
        Node secondNode = new Node(point);
        Edge edge = new Edge(firstNode, secondNode);

        graphLogic.addEdge(edge);
    }


    @Test
    @SuppressWarnings("ConstantConditions")
    void setDestinationNodeWithNull() {
        Node node = null;

        graphLogic.setDestinationNode(node);

        assertNull(graphLogic.getDestinationNode());
    }

    @Test
    void setDestinationNodeWithReference() {
        graphLogic.addNode(point);
        graphLogic.addNode(point);

        graphLogic.setDestinationNode(graphLogic.lists.getListOfNodes().get(0));

        assertSame(graphLogic.lists.getListOfNodes().get(0), graphLogic.getDestinationNode());
    }

    @Test
    void isNodeAnSourceNodeEqualsFalse() {
        Node node = new Node(point);

        assertFalse(graphLogic.isSource(node));
    }

    @Test
    void isNodeAnSourceNodeEqualsTrue() {
        graphLogic.addNode(point);

        assertTrue(graphLogic.isSource(graphLogic.lists.getListOfNodes().get(0)));
    }

    @Test
    void isNodeAnDestinationNodeEqualsFalse() {
        Node node = new Node(point);

        assertFalse(graphLogic.isDestination(node));
    }

    @Test
    void isNodeAnDestinationNodeEqualsTrue() {
        graphLogic.addNode(point);

        graphLogic.setDestinationNode(graphLogic.lists.getListOfNodes().get(0));

        assertTrue(graphLogic.isDestination(graphLogic.lists.getListOfNodes().get(0)));
    }

    @Test
    void setDefaultValueToCount() {
        for (int i = 0; i < 30; i++) {
            graphLogic.addNode(point);
        }
        assertEquals(30, graphLogic.lists.getListOfNodes().get(graphLogic.lists.getListOfNodes().size() - 1).getIdentifier());
        graphLogic.setDefaultValues();

        assertEquals(1, graphLogic.getCount());
    }

    @Test
    void setDefaultValueOfLists(){
        for (int i = 0; i < 30; i++) {
            graphLogic.addNode(point);
        }

        assertEquals(30, graphLogic.lists.getListOfNodes().get(graphLogic.lists.getListOfNodes().size() - 1).getIdentifier());
        graphLogic.setDefaultValues();

        assertEquals(0, graphLogic.lists.getListOfNodes().size());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void setDefaultValueToIsSolved(){
        boolean solved = true;
        graphLogic.setSolved(solved);
        assertTrue(graphLogic.isSolved());

        graphLogic.setDefaultValues();

        assertFalse(graphLogic.isSolved());
    }

    @Test
    void setDefaultValueToSourceNode(){
        graphLogic.addNode(point);
        assertNotNull(graphLogic.getSourceNode());

        graphLogic.setDefaultValues();

        assertNull(graphLogic.getSourceNode());
    }

    @Test
    void setDefaultValueToDestinationNode(){
        graphLogic.addNode(point);
        graphLogic.setDestinationNode(graphLogic.lists.getListOfNodes().get(0));
        assertNotNull(graphLogic.getSourceNode());

        graphLogic.setDefaultValues();

        assertNull(graphLogic.getSourceNode());
    }

    @Test
    void deleteNode(){
        assertEquals(0, graphLogic.lists.getListOfNodes().size());
        graphLogic.addNode(point);
        assertEquals(1, graphLogic.lists.getListOfNodes().size());

        graphLogic.deleteNode(graphLogic.lists.getListOfNodes().get(0));

        assertEquals(0, graphLogic.lists.getListOfNodes().size());
    }
}