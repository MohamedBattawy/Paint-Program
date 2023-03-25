package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ShapeResizerFactory {
    public ShapeResizer createShapeResizer(Shape s) {
        if (s instanceof Ellipse2D.Float){
            return new CircleResizer();
        }
        if (s instanceof Rectangle2D.Float)
        {
            Rectangle2D test =(Rectangle2D.Float) s;
            if(test.getWidth()==test.getHeight())
                return new SquareResizer();
            else
                return new RectangleResizer();
        }
        if (s instanceof Line2D.Float){
            return new LineResizer();
        }
        if (s instanceof Polygon){
            return new TriangleResizer();
        }
        return null;
    }
}
