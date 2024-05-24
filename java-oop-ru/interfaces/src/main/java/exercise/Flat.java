package exercise;

// BEGIN
public class Flat implements Home {

    private double area;

    private double balconyArea;

    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
        print();
    }

    public void print() {
        System.out.println(toString());
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
        return "Квартира площадью " + area + " метров на " + floor + " этаже";
    }
}

// END
