package Dijkstra.Program.View;

import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.GraphLogic;
import Dijkstra.Program.Model.Node;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
public class MouseInteractions extends JPanel implements MouseListener, MouseMotionListener {

    private GraphLogic graphLogic;
    private Node selectedNode = null;
    private Node hoveredNode = null;
    private Edge hoveredEdge = null;
    private java.util.List<Node> path = null;
    private Point point;

    public MouseInteractions(GraphLogic graphLogic) {
        this.graphLogic = graphLogic;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void setPath(List<Node> path) {
        this.path = path;
        hoveredEdge = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        PaintingTools paintingTools = new PaintingTools(graphics2d);

        if (graphLogic.isSolved()) {
            paintingTools.drawPath(path);
        }

        if (selectedNode != null && point != null) {
            Edge e = new Edge(selectedNode, new Node(point));
            paintingTools.drawEdge(e);
        }

        for (Edge edge : graphLogic.lists.getListOfEdges()) {
            if (edge == hoveredEdge)
                paintingTools.drawHoveredEdge(edge);
            paintingTools.drawEdge(edge);
        }

        for (Node node : graphLogic.lists.getListOfNodes()) {
            if (node == selectedNode || node == hoveredNode)
                paintingTools.drawHalo(node);
            if (graphLogic.isSource(node))
                paintingTools.drawSourceNode(node);
            else if (graphLogic.isDestination(node))
                paintingTools.drawDestinationNode(node);
            else
                paintingTools.drawNode(node);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Node selected = null;
        for (Node node : graphLogic.lists.getListOfNodes()) {
            if (PaintingTools.isWithinBounds(e, node.getPoint())) {
                selected = node;
                break;
            }
        }

        if (selected != null) {
            if (e.isControlDown() && e.isShiftDown()) {
                graphLogic.deleteNode(selected);
                graphLogic.setSolved(false);
                repaint();
                return;
            } else if (e.isControlDown() && graphLogic.isSolved()) {
                path = selected.getNodeList();
                repaint();
                return;
            } else if (e.isShiftDown()) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (!graphLogic.isDestination(selected)) {
                        graphLogic.setSourceNode(selected);
                    } else {
                        JOptionPane.showMessageDialog(null, ViewConstants.DESTINATION_NODE_MESSAGE);
                    }
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    if (!graphLogic.isSource(selected))
                        graphLogic.setDestinationNode(selected);
                    else
                        JOptionPane.showMessageDialog(null, ViewConstants.SOURCE_NODE_MESSAGE);
                } else
                    return;

                graphLogic.setSolved(false);
                repaint();
                return;
            }
        }

        if (hoveredEdge != null) {
            if (e.isControlDown() && e.isShiftDown()) {
                graphLogic.lists.getListOfEdges().remove(hoveredEdge);
                hoveredEdge = null;
                graphLogic.setSolved(false);
                repaint();
                return;
            }

            AtomicReference<String> input = new AtomicReference<>(JOptionPane.showInputDialog("User manual:\nWeight can be only between 1 and " + Integer.MAX_VALUE +
                    "\n\nEnter weight for " + hoveredEdge.toString()
                    + " : "));

            try {
                int weight = Integer.parseInt(input.get());
                if (weight > 0) {
                    hoveredEdge.setWeight(weight);
                    graphLogic.setSolved(false);
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(null, ViewConstants.WEIGHT_LOWER_THAN_ONE);
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                if(!input.get().isEmpty()) {
                    JOptionPane.showMessageDialog(null, ViewConstants.WRONG_INPUT);
                }
            }
            return;
        }

        for (Node node : graphLogic.lists.getListOfNodes()) {
            if (PaintingTools.isOverlapping(e, node.getPoint())) {
                JOptionPane.showMessageDialog(null, ViewConstants.OVERLAPPING_NODE);
                return;
            }
        }

        graphLogic.addNode(e.getPoint());
        graphLogic.setSolved(false);
        repaint();
    }

    @Override
    @SuppressWarnings("unused")
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (Node node : graphLogic.lists.getListOfNodes()) {
            if (selectedNode != null && node != selectedNode && PaintingTools.isWithinBounds(e, node.getPoint())) {
                Edge new_edge = new Edge(selectedNode, node);
                graphLogic.addEdge(new_edge);
                graphLogic.setSolved(false);
            }
        }
        selectedNode = null;
        hoveredNode = null;
        repaint();
    }

    @Override
    @SuppressWarnings("unused")
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    @SuppressWarnings("unused")
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        hoveredNode = null;

        for (Node node : graphLogic.lists.getListOfNodes()) {
            if (selectedNode == null && PaintingTools.isWithinBounds(e, node.getPoint())) {
                selectedNode = node;
            } else if (PaintingTools.isWithinBounds(e, node.getPoint())) {
                hoveredNode = node;
            }
        }

        if (selectedNode != null) {
            if (e.isControlDown()) {
                selectedNode.setPoint(e.getX(), e.getY());
                point = null;
                repaint();
                return;
            }
            point = new Point(e.getX(), e.getY());
            repaint();
        }
    }

    @Override
    public void mouseMoved(@NotNull MouseEvent e) {

        if (e.isControlDown()) {
            hoveredNode = null;
            for (Node node : graphLogic.lists.getListOfNodes()) {
                if (PaintingTools.isWithinBounds(e, node.getPoint())) {
                    hoveredNode = node;
                }
            }
        }
        hoveredEdge = null;

        for (Edge edge : graphLogic.lists.getListOfEdges()) {
            if (PaintingTools.isOnEdge(e, edge)) {
                hoveredEdge = edge;
            }
        }
        repaint();
    }

    void reset() {
        graphLogic.setDefaultValues();
        selectedNode = null;
        hoveredNode = null;
        hoveredEdge = null;
        repaint();
    }
}
