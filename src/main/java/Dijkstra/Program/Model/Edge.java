package Dijkstra.Program.Model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Edge implements ModelConstants {
    private Node firstNode;
    private Node secondNode;
    private int weight;

    @Contract(pure = true)
    public Edge(Node firstNode, Node secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.weight = 1;
    }

    public boolean isNode(Node node) {
        return firstNode == node || secondNode == node;
    }

    boolean equals(@NotNull Edge edge) {
        return (firstNode == edge.firstNode && secondNode == edge.secondNode) || (firstNode == edge.secondNode && secondNode == edge.firstNode);
    }

    @Override
    public String toString() {
              return ModelConstants.EDGE
                + getFirstNode().getIdentifier() + ModelConstants.DASH_SIGN
                + getSecondNode().getIdentifier();
    }
}
