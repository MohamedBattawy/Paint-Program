package FinalProject;

public class ShapeMakerFactory {
public ShapeMakerStrategy createShapeMaker(String s , int x1, int x2 , int y1 , int y2) {
    switch (s){
        case "draw line": return new LineMaker(x1,x2,y1,y2);
        case "draw square": return new SquareMaker(x1,x2,y1,y2);
        case "draw rectangle": return new RectangleMaker(x1,x2,y1,y2);
        case "draw triangle": return new TriangleMaker(x1,x2,y1,y2);
        case "draw circle": return new CircleMaker(x1,x2,y1,y2);
    }
    return null;
}
}
