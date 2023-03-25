package FinalProject;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineResizer implements ShapeResizer {
    public Shape Resize(Shape s, float amount){
        Line2D.Float p = (Line2D.Float) s;
        p.x1 += amount;
        p.x2 -= amount;
        p.y1 +=amount;
        p.y2 -=amount;
         return p;
    }
}
