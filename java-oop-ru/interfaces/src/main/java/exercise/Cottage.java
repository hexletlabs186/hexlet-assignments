package exercise;

// BEGIN

// BEGIN
public class Cottage implements Home {

    private double area;

    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home home) {
        if (this.area == home.getArea()) {
            return 0;
        } else if (this.area < home.getArea()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}

// END


// END
