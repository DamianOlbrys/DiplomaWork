package Dijkstra.Program.View;

import Dijkstra.Program.Model.Edge;
import Dijkstra.Program.Model.Node;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

import static Dijkstra.Program.View.PaintingCalculations.distToSegment;

public class PaintingTools {

    private Graphics2D g;
    private static int radius = ViewConstants.RADIUS;

    @Contract(pure = true)
    public PaintingTools() {

    }

    @Contract(pure = true)
    PaintingTools(Graphics2D graphics2D) {
        g = graphics2D;
    }

    public static boolean isWithinBounds(@NotNull MouseEvent e, @NotNull Point p) {
        int x = e.getX();
        int y = e.getY();

        int boundX = (int) p.getX();
        int boundY = (int) p.getY();

        return (x <= boundX + radius && x >= boundX - radius) && (y <= boundY + radius && y >= boundY - radius);
    }

    public static boolean isOverlapping(@NotNull MouseEvent e, @NotNull Point p) {
        int x = e.getX();
        int y = e.getY();

        int boundX = (int) p.getX();
        int boundY = (int) p.getY();

        return (x <= boundX + ViewConstants.MULTIPLIER * radius && x >= boundX - ViewConstants.MULTIPLIER * radius)
                && (y <= boundY + ViewConstants.MULTIPLIER * radius && y >= boundY - ViewConstants.MULTIPLIER * radius);
    }

    public static boolean isOnEdge(@NotNull MouseEvent e, @NotNull Edge edge) {

        int dist = distToSegment(e.getPoint(),
                edge.getFirstNode().getPoint(),
                edge.getSecondNode().getPoint());
        return dist < ViewConstants.EDGE_DISTANCE;
    }

    @NotNull
    @Contract(ViewConstants.CONTRACT_NEW)
    static Color parseColor(@NotNull String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), ViewConstants.SIXTEEN),
                Integer.valueOf(colorStr.substring(3, 5), ViewConstants.SIXTEEN),
                Integer.valueOf(colorStr.substring(5, 7), ViewConstants.SIXTEEN));
    }

    private void drawWeight(@NotNull Edge edge) {
        Point from = edge.getFirstNode().getPoint();
        Point to = edge.getSecondNode().getPoint();
        int x = (from.x + to.x) / ViewConstants.TWO;
        int y = (from.y + to.y) / ViewConstants.TWO;

        int rad = radius / ViewConstants.TWO;
        g.fillOval(x - rad, y - rad,
                ViewConstants.TWO * rad, ViewConstants.TWO * rad);
        drawWeightText(String.valueOf(edge.getWeight()), x, y);
    }

    void drawPath(@NotNull java.util.List<Node> path) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            edges.add(new Edge(path.get(i), path.get(i + 1)));
        }

        for (Edge edge : edges) {
            drawPath(edge);
        }
    }

    private void drawPath(Edge edge) {
        g.setColor(parseColor(ViewConstants.PATH_COLOR));
        drawBoldEdge(edge);
    }

    void drawHoveredEdge(Edge edge) {
        g.setColor(parseColor(ViewConstants.HOVERED_EDGE_COLOR));
        drawBoldEdge(edge);
    }

    private void drawBoldEdge(@NotNull Edge edge) {
        Point from = edge.getFirstNode().getPoint();
        Point to = edge.getSecondNode().getPoint();
        g.setStroke(new BasicStroke(ViewConstants.BOLD_EDGE));
        g.drawLine(from.x, from.y, to.x, to.y);
        int x = (from.x + to.x) / ViewConstants.TWO;
        int y = (from.y + to.y) / ViewConstants.TWO;
        int rad = ViewConstants.HALF_OF_RADIUS;
        g.fillOval(x - rad, y - rad, ViewConstants.TWO * rad, ViewConstants.TWO * rad);
    }

    void drawEdge(Edge edge) {
        g.setColor(parseColor(ViewConstants.PATH_COLOR));
        drawBaseEdge(edge);
        drawWeight(edge);
    }

    private void drawBaseEdge(@NotNull Edge edge) {
        Point from = edge.getFirstNode().getPoint();
        Point to = edge.getSecondNode().getPoint();
        g.setStroke(new BasicStroke(ViewConstants.BASE_EDGE));
        g.drawLine(from.x, from.y, to.x, to.y);
    }

    void drawHalo(@NotNull Node node) {
        g.setColor(parseColor(ViewConstants.HALO_COLOR));
        radius += 5;
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);
        radius -= 5;
    }

    void drawSourceNode(Node node) {
        g.setColor(parseColor(ViewConstants.SOURCE_NODE_COLOR));
        fillOval(node, ViewConstants.SOURCE_NODE_OVAL_COLOR);
        g.setColor(parseColor(ViewConstants.SOURCE_NODE_COLOR));
        drawCentreText(String.valueOf(node.getIdentifier()), node.getX(), node.getY());
    }

    private void fillOval(@NotNull Node node, String s) {
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius -= 5;
        g.setColor(parseColor(s));
        g.fillOval(node.getX() - radius, node.getY() - radius, 2 * radius, 2 * radius);

        radius += 5;
    }

    void drawDestinationNode(Node node) {
        g.setColor(parseColor(ViewConstants.DESTINATION_NODE_COLOR));
        fillOval(node, ViewConstants.DESTINATION_NODE_OVAL_COLOR);
        g.setColor(parseColor(ViewConstants.DESTINATION_NODE_COLOR));
        drawCentreText(String.valueOf(node.getIdentifier()), node.getX(), node.getY());
    }

    void drawNode(Node node) {
        g.setColor(parseColor(ViewConstants.COMMON_NODE_COLOR));
        fillOval(node, ViewConstants.COMMON_NODE_OVAL_COLOR);
        g.setColor(parseColor(ViewConstants.COMMON_NODE_COLOR));
        drawCentreText(String.valueOf(node.getIdentifier()), node.getX(), node.getY());
    }

    private void drawWeightText(String text, int x, int y) {
        g.setColor(parseColor(ViewConstants.WEIGHT_TEXT_COLOR));
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }

    private void drawCentreText(String text, int x, int y) {
        FontMetrics fm = g.getFontMetrics();
        double t_width = fm.getStringBounds(text, g).getWidth();
        g.drawString(text, (int) (x - t_width / 2), (y + fm.getMaxAscent() / 2));
    }
}