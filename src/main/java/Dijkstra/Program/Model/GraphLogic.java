package Dijkstra.Program.Model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GraphLogic implements ModelConstants {

    public Lists lists = new Lists();

    private int count = ModelConstants.ONE;
    private boolean isSolved = false;
    private Node sourceNode;
    private Node destinationNode;

    public boolean isNodeReachable(Node node) {
        for (Edge edge : lists.getListOfEdges())
            if (node == edge.getFirstNode() || node == edge.getSecondNode()) {
                return true;
            }
        return false;
    }

    public void setSourceNode(Node node) {
        if (lists.getListOfNodes().contains(node))
            sourceNode = node;
    }

    public void setDestinationNode(Node node) {
        if (lists.getListOfNodes().contains(node)) {
            destinationNode = node;
        }
    }

    public boolean isSource(Node node) {
        return node == sourceNode;
    }

    public boolean isDestination(Node node) {
        return node == destinationNode;
    }

    public void addNode(Point point) {
        Node node = new Node(point);
        addNode(node);
    }

    private void addNode(@NotNull Node node) {
        node.setIdentifier(count++);
        lists.getListOfNodes().add(node);
        if (node.getIdentifier() == 1)
            setSourceNode(node);
    }

    public void addEdge(Edge edgeToAdd) {
        boolean added = false;
        for (Edge edge : lists.getListOfEdges()) {
            if (edge.equals(edgeToAdd)) {
                added = true;
                break;
            }
        }
        if (!added)
            lists.getListOfEdges().add(edgeToAdd);
    }

    public void deleteNode(Node node) {
        List<Edge> edgesToDelete = new ArrayList<>();
        for (Edge edge : lists.getListOfEdges()) {
            if (edge.isNode(node)) {
                edgesToDelete.add(edge);
            }
        }
        for (Edge edge : edgesToDelete) {
            lists.getListOfEdges().remove(edge);
        }
        lists.getListOfNodes().remove(node);
    }

    public void setDefaultValues() {
        count = ONE;
        lists.removeAllListElements();
        isSolved = false;
        sourceNode = null;
        destinationNode = null;
    }
}
