package Dijkstra.Program.View;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class PaintingCalculations {

    protected static int exponentiation(int value) {
        if (value >= Math.sqrt(Integer.MAX_VALUE)) {
            value = (int) Math.sqrt(value);
        } else if (value < -(Math.sqrt(Integer.MAX_VALUE))) {
            value = ViewConstants.ZERO;
        }
        return value * value;
    }

    protected static int distanceCalculation(@NotNull Point firstPoint, @NotNull Point secondPoint) {
        return exponentiation(firstPoint.x - secondPoint.x) + exponentiation(firstPoint.y - secondPoint.y);
    }

    protected static int distanceToSegmentSquared(Point firstPoint, Point secondPoint, Point thirdPoint) {
        double distance = distanceCalculation(secondPoint, thirdPoint);
        if (distance == 0) {
            return distanceCalculation(firstPoint, secondPoint);
        }
        double result = ((firstPoint.x - secondPoint.x) * (thirdPoint.x - secondPoint.x) + (firstPoint.y - secondPoint.y) * (thirdPoint.y - secondPoint.y)) / distance;
        if (result < 0) {
            return distanceCalculation(firstPoint, secondPoint);
        }
        if (result > 1) {
            return distanceCalculation(firstPoint, thirdPoint);
        }
        return distanceCalculation(firstPoint, new Point(
                (int) (secondPoint.x + result * (thirdPoint.x - secondPoint.x)),
                (int) (secondPoint.y + result * (thirdPoint.y - secondPoint.y))
        ));
    }

    public static int distToSegment(Point firstPoint, Point secondPoint, Point thirdPoint) {
        return (int) Math.sqrt(distanceToSegmentSquared(firstPoint, secondPoint, thirdPoint));
    }
}
