package TP07.ex1;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4,4);
        System.out.println("the perimeter of the rectangle is: "+rectangle.calculatePerimeter());
        System.out.println("the surface of the rectangle is: "+rectangle.calculateSurface());

    }
}
