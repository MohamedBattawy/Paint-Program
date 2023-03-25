package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleResizer implements ShapeResizer{
    public Shape Resize(Shape s, float amount){
        Ellipse2D.Float p = (Ellipse2D.Float) s;
        p.width += amount;
        p.height += amount;
        return p;
    }
}
