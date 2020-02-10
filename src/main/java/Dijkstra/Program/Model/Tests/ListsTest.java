package Dijkstra.Program.Model.Tests;

import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.Lists;
import Dijkstra.Program.Model.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {

    private Lists lists;

    @BeforeEach
    void setUp() {
        lists = new Lists();
    }

    @AfterEach
    void tearDown() {
        lists = null;
    }

    @Test
    void getListOfNodes() {
        List<Node> listOfNodes = new ArrayList<>();

        assertEquals(listOfNodes, lists.getListOfNodes());
    }

    @Test
    void getListOfEdges() {
        List<Edge> listOfEdges = new ArrayList<>();

        assertEquals(listOfEdges, lists.getListOfEdges());
    }

    @Test
    void removeAllListElements() {
        lists.removeAllListElements();

        assertEquals(0, lists.getListOfNodes().size());
        assertEquals(0, lists.getListOfEdges().size());

    }
}