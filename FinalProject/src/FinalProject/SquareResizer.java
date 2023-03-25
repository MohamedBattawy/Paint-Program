package FinalProject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SquareResizer implements ShapeResizer{
    public Shape Resize(Shape s, float amount){
        Rectangle2D.Float p = (Rectangle2D.Float) s;
        p.width += amount;
        p.height += amount;
        return p;
    }
}
