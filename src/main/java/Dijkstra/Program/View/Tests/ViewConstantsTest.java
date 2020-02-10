package Dijkstra.Program.View.Tests;

import Dijkstra.Program.View.ViewConstants;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class ViewConstantsTest implements ViewConstants {

    @Test
    void titleConstant() {
        String title = "Dijkstra Algorithm";

        assertThat(title, IsEqual.equalTo(ViewConstants.TITLE));
    }

    @Test
    void showMessageConstant() {
        String showMessage = "User manual: \n" +
                "1) Point on canvas and click in empty space to create new node \n" +
                "2) Point on node and drag to another to create an edge \n" +
                "3) Point and click on edge to set weight\n\n" +
                "Combinations:\n" +
                "Shift + Left Click       :    Set node as source\n" +
                "Shift + Right Click     :    Set node as destination\n" +
                "Ctrl  + Drag               :    Reposition Node\n" +
                "Ctrl  + Click                :    Get Path of Node\n" +
                "Ctrl  + Shift + Click   :    Delete Node/Edge\n";

        assertThat(showMessage, IsEqual.equalTo(ViewConstants.SHOW_MESSAGE));
    }

    @Test
    void blackColorConstant() {
        String pathColor = "#000000";

        assertThat(pathColor, IsEqual.equalTo(ViewConstants.PATH_COLOR));
    }

    @Test
    void hoveredEdgeColorConstant() {
        String hoveredEdge = "#FF0000";

        assertThat(hoveredEdge, IsEqual.equalTo(ViewConstants.HOVERED_EDGE_COLOR));
    }

    @Test
    void zeroConstant() {
        int zero = 0;

        assertEquals(zero, ViewConstants.ZERO);
    }

    @Test
    void radiusConstant() {
        int radius = 25;

        assertEquals(radius, ViewConstants.RADIUS);
    }

    @Test
    void halfOfRadiusConstant() {
        int halfOfRadius = 13;

        assertEquals(halfOfRadius, ViewConstants.HALF_OF_RADIUS);
    }

    @Test
    void edgeDistanceConstant() {
        int edgeDistance = 6;

        assertEquals(edgeDistance, ViewConstants.EDGE_DISTANCE);
    }

    @Test
    void twoConstant() {
        int two = 2;

        assertEquals(two, ViewConstants.TWO);
    }

    @Test
    void sexteenConstant() {
        int sixteen = 16;

        assertEquals(sixteen, ViewConstants.SIXTEEN);
    }

    @Test
    void boldEdgeConstant(){
        int boldEdge = 8;

        assertEquals(boldEdge, ViewConstants.BOLD_EDGE);
    }

    @Test
    void baseEdgeConstant(){
        int baseEdge = 2;

        assertEquals(baseEdge, ViewConstants.BASE_EDGE);
    }

    @Test
    void multiplierConstant(){
        double multiplier = 2.5;

        assertEquals(multiplier, ViewConstants.MULTIPLIER);
    }
}