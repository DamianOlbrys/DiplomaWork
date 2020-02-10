package Dijkstra.Program.Controller.Tests;

import Dijkstra.Program.Controller.DijkstraAlgorithm;
import Dijkstra.Program.Model.GraphLogic;
import Dijkstra.Program.Model.Node;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class DijkstraAlgorithmTest {

    private DijkstraAlgorithm dijkstraAlgorithm;
    private Map<Node, Integer> distances;

    private DijkstraAlgorithm.NodeComparator nodeComparator;
    private Node firstNode;
    private Node secondNode;

    @BeforeEach
    void setUp() {

        GraphLogic graphLogic = new GraphLogic();
        dijkstraAlgorithm = new DijkstraAlgorithm(graphLogic);
    }

    @Test
    void constructorDefaultListSize() {
        assertEquals(dijkstraAlgorithm.getGraphLogic().lists.getListOfNodes().size(), dijkstraAlgorithm.getDistances().size());
    }

    void nodeComparatorInitialization() {
        nodeComparator = dijkstraAlgorithm.new NodeComparator();
        distances = new HashMap<>();
        Point point = new Point(0, 0);
        firstNode = new Node(point);
        secondNode = new Node(point);
    }

    @Test
    void nodeComparatorEqualsZero() {
        nodeComparatorInitialization();

        distances.put(firstNode, 10);
        distances.put(secondNode, 10);
        dijkstraAlgorithm.setDistances(distances);

        assertEquals(0, nodeComparator.compare(firstNode, secondNode));
    }

    @Test
    void nodeComparatorGTZero() {
        nodeComparatorInitialization();
        int[] firstNodeValues = {1, 2, 412, 5, 3215, 43, 756, 372, 14, 763673, 125125};
        int[] secondNodeValues = {6537, 24361, 324, 15, 2437, 6, 1, 2, 635, 7548, 1111, 4124};

        for (int i = 0; i < firstNodeValues.length - 1; i++) {
            for (int j = 0; j < secondNodeValues.length - 1; j++) {

                distances.put(firstNode, firstNodeValues[i]);
                distances.put(secondNode, secondNodeValues[j]);
                dijkstraAlgorithm.setDistances(distances);
                assertEquals((firstNodeValues[i] - secondNodeValues[j]), nodeComparator.compare(firstNode, secondNode));
            }
        }
    }

    @Test
    void nodeComparatorLTZero() {
        nodeComparatorInitialization();
        int[] firstNodeValues = {-1, -2, -412, -5, -3215, -43, -756, -372, -14, -763673, -125125};
        int[] secondNodeValues = {-6537, -24361, -324, -15, -2437, -6, -1, -2, -635, -7548, -1111, -4124};

        for (int i = 0; i < firstNodeValues.length - 1; i++) {
            for (int j = 0; j < secondNodeValues.length - 1; j++) {

                distances.put(firstNode, firstNodeValues[i]);
                distances.put(secondNode, secondNodeValues[j]);
                dijkstraAlgorithm.setDistances(distances);
                assertEquals((firstNodeValues[i] - secondNodeValues[j]), nodeComparator.compare(firstNode, secondNode));
            }
        }
    }

    @Test
    void defaultDistancesSize() {
        assertEquals(dijkstraAlgorithm.getDistances().size(), dijkstraAlgorithm.getGraphLogic().lists.getListOfNodes().size());
    }

    @Test
    void runIsNotSafe(){
        IllegalStateException illegalStateException =  assertThrows(IllegalStateException.class,() -> dijkstraAlgorithm.run());

        assertThat("Source node have to be in the graph", IsEqual.equalTo(illegalStateException.getMessage()));
    }

    @Test
    void runUnvisited(){
        Point point = new Point();
        dijkstraAlgorithm.getGraphLogic().addNode(point);
        dijkstraAlgorithm.setSafe(true);

        dijkstraAlgorithm.run();

        assertEquals(0,dijkstraAlgorithm.getUnvisited().size());
}
}