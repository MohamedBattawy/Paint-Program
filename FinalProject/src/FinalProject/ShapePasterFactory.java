package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ShapePasterFactory {
    public ShapePaster createShapePaster(Shape s) {
        if (s instanceof Ellipse2D.Float){
            return new CirclePaster();
        }
        if (s instanceof Rectangle2D.Float)
        {
            Rectangle2D test =(Rectangle2D.Float) s;
            if(test.getWidth()==test.getHeight())
                return new SquarePaster();
            else
                return new RectanglePaster();
        }
       if (s instanceof Line2D.Float){
            return new LinePaster();
        }
        if (s instanceof Polygon){
            return new TrianglePaster();
        }
        return null;
    }
}
