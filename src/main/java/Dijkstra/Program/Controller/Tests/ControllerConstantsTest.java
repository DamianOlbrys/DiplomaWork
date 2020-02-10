package Dijkstra.Program.Controller.Tests;

import Dijkstra.Program.Controller.ControllerConstants;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class ControllerConstantsTest {
    @Test
    void sourceNodeMessageConstant() {
        String sourceNodeMessage = "Source node have to be in the graph";

        assertThat(sourceNodeMessage, IsEqual.equalTo(ControllerConstants.SOURCE_NODE_MESSAGE));
    }

    @Test
    void destinationNodeMessageConstant() {
        String destinationNodeMessage = "Destination must be present in the graphLogic";

        assertThat(destinationNodeMessage, IsEqual.equalTo(ControllerConstants.DESTINATION_NODE_MESSAGE));
    }

    @Test
    void unreachableNodeConstant() {
        String unreachableNodes = "Graph contains unreachable nodes";

        assertThat(unreachableNodes, IsEqual.equalTo(ControllerConstants.UNREACHABLE_NODES));
    }
}