package exercise;

import exercise.exception.NegativeRadiusException;

// BEGIN
public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) throw new NegativeRadiusException("Радиус меньше нуля");
        return Math.PI * radius * radius;
    }
}
// END
