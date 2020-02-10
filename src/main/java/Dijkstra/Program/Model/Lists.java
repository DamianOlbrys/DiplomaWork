package Dijkstra.Program.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Lists {
    private List<Node> listOfNodes = new ArrayList<>();
    private List<Edge> listOfEdges = new ArrayList<>();

    public void removeAllListElements() {
        getListOfNodes().clear();
        getListOfEdges().clear();
    }
}
