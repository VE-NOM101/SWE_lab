// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory1=ShapeFactory.getInstance();

        ShapeFactory shapeFactory2=ShapeFactory.getInstance();

        System.out.println("Hashcode of shape1 is "
                + shapeFactory1.hashCode());
        System.out.println("Hashcode of shape2 is "
                + shapeFactory2.hashCode());


        Shape shape1 =shapeFactory1.getShape("SQUARE");shape1.draw();
        Shape shape2 = shapeFactory2.getShape("RECTANGLE");shape2.draw();


    }
}