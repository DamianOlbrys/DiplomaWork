package Dijkstra.Program.View.Tests;

import Dijkstra.Program.View.PaintingCalculations;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class PaintingCalculationsTest extends PaintingCalculations {

    @Test
    void exponentiationWithPositiveSet() {
        int[] valuesToTest = {0, 1, 42, 1244, 2124, 9999123, 3123, 123, 11, 2415, 7864, 3, 24, 51345, 16, Integer.MAX_VALUE};

        for (int values : valuesToTest) {
            if (values >= Math.sqrt(Integer.MAX_VALUE)) {
                values = (int) Math.sqrt(values);
            }
            assertEquals((values * values), PaintingCalculations.exponentiation(values));
        }
    }

    @Test
    void exponentiationWithNegativeSet() {
        int[] valuesToTest = {-1, -42, -1244, -2124, -9999123, -3123, -123, -11, -2415, -7864, -3, -24, -51345, -16, Integer.MIN_VALUE};

        for (int values : valuesToTest) {
            if (values >= Math.sqrt(values)) {
                values = (int) Math.sqrt(values);
            } else if (values < -((int) Math.sqrt(values))) {
                values = -((int) Math.sqrt(values));
            }
            assertEquals((values * values), PaintingCalculations.exponentiation(values));
        }
    }

    @Test
    void distanceToWithPositiveSetOfX() {
        int[] XPointValuesToTest = {0, 1, 2, 412, 41222, 5123124, 9975979, 3321, 2241, 67712, Integer.MAX_VALUE};

        for (int values : XPointValuesToTest) {
            assertEquals(0, PaintingCalculations.distanceCalculation(new Point(values, 0), new Point(values, 0)));
        }
    }

    @Test
    void distanceToWithPositiveSetOfY() {
        int[] YPointValuesToTest = {0, 1, 2, 412, 41222, 5123124, 9975979, 3321, 2241, 67712, Integer.MAX_VALUE};

        for (int values : YPointValuesToTest) {
            assertEquals(0, PaintingCalculations.distanceCalculation(new Point(0, values), new Point(0, values)));
        }
    }

    @Test
    void distanceToWithPNegativeSetOfX() {
        int[] XPointValuesToTest = {-1, -2, -412, -41222, -5123124, -9975979, -3321, -2241, -67712, Integer.MIN_VALUE};

        for (int values : XPointValuesToTest) {
            assertEquals(0, distanceCalculation(new Point(values, 0), new Point(values, 0)));
        }
    }

    @Test
    void distanceToWithNegativeSetOfY() {
        int[] YPointValuesToTest = {-1, -2, -412, -41222, -5123124, -9975979, -3321, -2241, -67712, Integer.MIN_VALUE};

        for (int values : YPointValuesToTest) {
            assertEquals(0, PaintingCalculations.distanceCalculation(new Point(0, values), new Point(0, values)));
        }
    }

    @Test
    void distanceToSegmentSquaredEqualsZero() {
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,0);
        Point thirdPoint = new Point(0,0);

        assertEquals(0,PaintingCalculations.distanceToSegmentSquared(firstPoint,secondPoint,thirdPoint));
    }

    @Test
    void distanceToSegmentSquaredGTZero() {
        Point firstPoint = new Point(10,20);
        Point secondPoint = new Point(30,40);
        Point thirdPoint = new Point(50,60);

        assertEquals(800,PaintingCalculations.distanceToSegmentSquared(firstPoint,secondPoint,thirdPoint));
    }

    @Test
    void distanceToSegmentEqualsZero(){
        Point firstPoint = new Point(0,0);
        Point secondPoint = new Point(0,0);
        Point thirdPoint = new Point(0,0);

        assertEquals(0,PaintingCalculations.distToSegment(firstPoint,secondPoint,thirdPoint));
    }

    @Test
    void distanceToSegmentGTZero(){
        Point firstPoint = new Point(10,20);
        Point secondPoint = new Point(30,40);
        Point thirdPoint = new Point(50,60);

        assertEquals(28,PaintingCalculations.distToSegment(firstPoint,secondPoint,thirdPoint));
    }
}