package Dijkstra.Program.Controller;

import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.GraphLogic;
import Dijkstra.Program.Model.Node;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@Getter
@Setter
public class DijkstraAlgorithm {

    private boolean safe;

    private GraphLogic graphLogic;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distances;
    private PriorityQueue<Node> unvisited;
    private HashSet<Node> visited;
    private Evaluation evaluation;

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return distances.get(node1) - distances.get(node2);
        }
    }

    public DijkstraAlgorithm(@NotNull GraphLogic graphLogic) {
        this.graphLogic = graphLogic;
        predecessors = new HashMap<>();
        distances = new HashMap<>();
        evaluation = new Evaluation(graphLogic);

        for (Node node : graphLogic.lists.getListOfNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        visited = new HashSet<>();
        safe = evaluation.evaluate();
    }

    public void run() throws IllegalStateException {
        if (!safe) {
            throw new IllegalStateException(evaluation.getMessage());
        }

        unvisited = new PriorityQueue<>(graphLogic.lists.getListOfNodes().size(), new NodeComparator());

        Node source = graphLogic.getSourceNode();

        distances.put(source, 0);
        visited.add(source);

        for (Edge neighbor : getNeighbors(source)) {
            Node adjacent = getAdjacent(neighbor, source);
            if (adjacent == null)
                continue;

            distances.put(adjacent, neighbor.getWeight());
            predecessors.put(adjacent, source);
            unvisited.add(adjacent);
        }

        while (!unvisited.isEmpty()) {
            Node current = unvisited.poll();
            updateDistance(current);
            unvisited.remove(current);
            visited.add(current);
        }
        for (Node node : graphLogic.lists.getListOfNodes()) {
            node.setNodeList(getPath(node));
        }
        graphLogic.setSolved(true);

    }

    private void updateDistance(Node node) {
        int distance = distances.get(node);

        for (Edge neighbor : getNeighbors(node)) {
            Node adjacent = getAdjacent(neighbor, node);
            if (visited.contains(adjacent))
                continue;

            int current_dist = distances.get(adjacent);
            int new_dist = distance + neighbor.getWeight();

            if (new_dist < current_dist) {
                distances.put(adjacent, new_dist);
                predecessors.put(adjacent, node);
                unvisited.add(adjacent);
            }
        }
    }

    @Nullable
    private Node getAdjacent(@NotNull Edge edge, Node node) {
        if (edge.getFirstNode() != node && edge.getSecondNode() != node)
            return null;

        return node == edge.getSecondNode() ? edge.getFirstNode() : edge.getSecondNode();
    }

    @NotNull
    private List<Edge> getNeighbors(Node node) {
        List<Edge> neighbors = new ArrayList<>();

        for (Edge edge : graphLogic.lists.getListOfEdges()) {
            if (edge.getFirstNode() == node || edge.getSecondNode() == node)
                neighbors.add(edge);
        }
        return neighbors;
    }

    public List<Node> getDestinationPath() {
        return getPath(graphLogic.getDestinationNode());
    }

    @NotNull
    private List<Node> getPath(Node node) {
        List<Node> path = new ArrayList<>();

        Node current = node;
        path.add(current);
        while (current != graphLogic.getSourceNode()) {
            current = predecessors.get(current);
            path.add(current);
        }

        Collections.reverse(path);

        return path;
    }
}

