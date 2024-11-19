import java.util.Scanner;

interface Polygon {
    default double getPerimeter(double[] sides) {
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    double getArea();
}

class Rectangle implements Polygon {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

class Triangle implements Polygon {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

public class Perimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length and width of the rectangle:");
        double rectLength = scanner.nextDouble();
        double rectWidth = scanner.nextDouble();

        Rectangle rect = new Rectangle(rectLength, rectWidth);
        System.out.println("Enter the four sides of the rectangle:");
        double[] rectSides = new double[4];
        for (int i = 0; i < 4; i++) {
            rectSides[i] = scanner.nextDouble();
        }
        System.out.println("Rectangle Perimeter: " + rect.getPerimeter(rectSides));
        System.out.println("Rectangle Area: " + rect.getArea());

        System.out.println("Enter the base and height of the triangle:");
        double triBase = scanner.nextDouble();
        double triHeight = scanner.nextDouble();

        Triangle tri = new Triangle(triBase, triHeight);
        System.out.println("Enter the three sides of the triangle:");
        double[] triSides = new double[3];
        for (int i = 0; i < 3; i++) {
            triSides[i] = scanner.nextDouble();
        }
        System.out.println("Triangle Perimeter: " + tri.getPerimeter(triSides));
        System.out.println("Triangle Area: " + tri.getArea());

        scanner.close();
    }
}
