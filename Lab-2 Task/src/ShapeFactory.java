public class ShapeFactory {

    private static final ShapeFactory instance = new ShapeFactory();
    private ShapeFactory(){}
    public static ShapeFactory getInstance() {
        return instance;
    }
    public Shape getShape(String shapeType){

        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}