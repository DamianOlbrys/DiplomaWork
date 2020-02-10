package Dijkstra.Program.View;

public interface ViewConstants {
    String CONTRACT_NEW = "_ -> new";
    String TITLE = "Dijkstra Algorithm";
    String SHOW_MESSAGE = "User manual: \n" +
                        "1) Point on canvas and click in empty space to create new node \n" +
                        "2) Point on node and drag to another to create an edge \n" +
                        "3) Point and click on edge to set weight\n\n" +
                        "Combinations:\n" +
                        "Shift + Left Click       :    Set node as source\n" +
                        "Shift + Right Click     :    Set node as destination\n" +
                        "Ctrl  + Drag               :    Reposition Node\n" +
                        "Ctrl  + Click                :    Get Path of Node\n" +
                        "Ctrl  + Shift + Click   :    Delete Node/Edge\n";

    String PATH_COLOR = "#000000";
    String HOVERED_EDGE_COLOR = "#FF0000";
    String HALO_COLOR = "#00FF00";
    String SOURCE_NODE_COLOR = "#7A70F7";
    String SOURCE_NODE_OVAL_COLOR = "#ABE4EB";
    String DESTINATION_NODE_COLOR = "#FF0000" ;
    String DESTINATION_NODE_OVAL_COLOR = "#FFC9B5";
    String COMMON_NODE_COLOR = "#000000";
    String COMMON_NODE_OVAL_COLOR = "#9E9E9E";
    String WEIGHT_TEXT_COLOR = "#CCCCCC";

    String DESTINATION_NODE_MESSAGE = "Destination node can't be the same as Source node";
    String SOURCE_NODE_MESSAGE = "Source node can't be the same as Destination node";
    String WEIGHT_LOWER_THAN_ONE = "Weight can't be negative or equal zero";
    String WRONG_INPUT = "Wrong input!";
    String OVERLAPPING_NODE = "Overlapping Node can't be created";

    int ZERO = 0;
    int RADIUS = 25;
    int HALF_OF_RADIUS = 13;
    int EDGE_DISTANCE = 6;
    int TWO = 2;
    int SIXTEEN = 16;
    int BOLD_EDGE = 8;
    int BASE_EDGE = 2;

    double MULTIPLIER =  2.5;
}
