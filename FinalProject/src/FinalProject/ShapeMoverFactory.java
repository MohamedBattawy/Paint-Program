package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ShapeMoverFactory {
    public ShapeMover createShapeMover(Shape s) {
        if (s instanceof Ellipse2D.Float){
            return new CircleMover();
        }
        if (s instanceof Rectangle2D.Float)
        {
            Rectangle2D test =(Rectangle2D.Float) s;
            if(test.getWidth()==test.getHeight())
            return new SquareMover();
            else
                return new RectangleMover();
        }
        if (s instanceof Line2D.Float){
            return new LineMover();
        }
        if (s instanceof Polygon){
            return new TriangleMover();
        }
        return null;
    }
}
