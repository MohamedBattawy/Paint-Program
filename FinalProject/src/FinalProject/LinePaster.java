package FinalProject;

import java.awt.*;
import java.awt.geom.Line2D;

import static java.lang.Math.abs;

public class LinePaster implements ShapePaster{
    public Shape paste(Shape s, int dx, int dy) {
        Line2D.Float p = (Line2D.Float) s;
        float length,width;
        length=abs(p.x1-p.x2);
        width=abs(p.y1-p.y2);
        p.x1 = dx;
        p.y1 = dy;
        p.x2 = dx+length;
        p.y2 = dy+width;
        return p;
    }
}
