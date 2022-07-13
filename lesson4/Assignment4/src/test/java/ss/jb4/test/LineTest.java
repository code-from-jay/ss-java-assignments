package ss.jb4.test;

import org.junit.jupiter.api.Test;
import ss.jb4.main.Line;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {
    public final double ROUNDING_EPSILON = .000001d;

    @Test
    public void getSlopeReturnsAccurateValue() {
        Line line1 = new Line(1, 1, 2, 2);
        Line line2 = new Line(2, 8, 4, 9);
        assertTrue(Math.abs(line1.getSlope() - 1d) < ROUNDING_EPSILON);
        assertTrue(Math.abs(line2.getSlope() - 0.5d) < ROUNDING_EPSILON);
    }

    @Test
    public void getDistanceReturnsAccurateValue() {
        Line line1 = new Line(2, 0, 2, 9);
        Line line2 = new Line(0, 0, 2, 6);
        assertTrue(Math.abs(line1.getDistance() - 9d) < ROUNDING_EPSILON);
        assertTrue(Math.abs(line2.getDistance() - 6.3245553203368d) < ROUNDING_EPSILON);
    }

    @Test
    public void parallelToReturnsAccurateValue() {
        Line line1 = new Line(2, 4, 4, 6);
        Line line2 = new Line(1, 3, 3, 5);
        assertTrue(line1.parallelTo(line2));
    }
}
