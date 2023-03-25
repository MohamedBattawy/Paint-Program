package FinalProject;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineMover implements ShapeMover {
    public Shape move(Shape s, int dx, int dy) {
        Line2D.Float p = (Line2D.Float) s;
        p.x1 += dx;
        p.x2+=dx;
        p.y1+=dy;
        p.y2 += dy;
        return p;
    }

}
