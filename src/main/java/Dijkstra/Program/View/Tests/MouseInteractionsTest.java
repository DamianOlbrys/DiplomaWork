package Dijkstra.Program.View.Tests;

import Dijkstra.Program.View.MouseInteractions;
import Dijkstra.Program.Model.GraphLogic;
import Dijkstra.Program.Model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MouseInteractionsTest {

    private MouseInteractions mouseInteractions;

    @BeforeEach
    void setUp() {
        GraphLogic graphLogic = new GraphLogic();
        mouseInteractions = new MouseInteractions(graphLogic);
    }

    @Test
    void setPathNotNull() {
        java.util.List<Node> path = new ArrayList<>();
        mouseInteractions.setPath(path);
        assertNotNull(mouseInteractions.getPath());
    }
}