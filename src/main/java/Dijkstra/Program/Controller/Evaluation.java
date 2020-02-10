package Dijkstra.Program.Controller;

import Dijkstra.Program.Model.GraphLogic;
import Dijkstra.Program.Model.Node;
import lombok.Getter;
import org.jetbrains.annotations.Contract;

@Getter
public class Evaluation {

    private GraphLogic graphLogic;
    private String message;

    @Contract(pure = true)
    public Evaluation(GraphLogic graphLogic) {
        this.graphLogic = graphLogic;
    }

    public boolean evaluate() {
        if (graphLogic.getSourceNode() == null) {
            message = ControllerConstants.SOURCE_NODE_MESSAGE;
            return false;
        }

        if (graphLogic.getDestinationNode() == null) {
            message = ControllerConstants.DESTINATION_NODE_MESSAGE;
            return false;
        }

        for (Node node : graphLogic.lists.getListOfNodes()) {
            if (!graphLogic.isNodeReachable(node)) {
                message = ControllerConstants.UNREACHABLE_NODES;
                return false;
            }
        }
        return true;
    }
}
