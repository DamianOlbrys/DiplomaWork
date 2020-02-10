package Dijkstra.Program.Controller.Tests;

import Dijkstra.Program.Controller.Evaluation;
import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.GraphLogic;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EvaluationTest {

    private Evaluation evaluation;
    private GraphLogic graphLogic;

    @BeforeEach
    void setUp() {
        graphLogic = new GraphLogic();
        evaluation = new Evaluation(graphLogic);
    }

    @AfterEach
    void tearDown() {
        evaluation = null;
    }

    @Test
    void getNullMessage() {
        assertNull(evaluation.getMessage());
    }

    @Test
    void getSourceNodeMessage() {
        evaluation.evaluate();

        assertThat("Source node have to be in the graph", IsEqual.equalTo(evaluation.getMessage()));
    }

    @Test
    void getDestinationNodeMessage() {
        Point point = new Point();

        graphLogic.addNode(point);
        evaluation.evaluate();

        assertThat("Destination must be present in the graphLogic", IsEqual.equalTo(evaluation.getMessage()));
    }

    @Test
    void getUnreachableNodeMessage() {
        Point point = new Point();

        graphLogic.addNode(point);
        graphLogic.setDestinationNode(graphLogic.lists.getListOfNodes().get(0));
        evaluation.evaluate();

        assertThat("Graph contains unreachable nodes", IsEqual.equalTo(evaluation.getMessage()));
    }

    @Test
    void getTrueAsEvaluateReturn() {
        Point point = new Point();
        graphLogic.addNode(point);
        graphLogic.addNode(point);

        Edge edge = new Edge(graphLogic.lists.getListOfNodes().get(0), graphLogic.lists.getListOfNodes().get(1));
        graphLogic.setDestinationNode(graphLogic.lists.getListOfNodes().get(0));
        graphLogic.addEdge(edge);

        assertTrue(evaluation.evaluate());
    }
}