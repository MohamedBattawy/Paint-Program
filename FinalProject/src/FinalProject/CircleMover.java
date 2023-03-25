package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleMover implements ShapeMover{
    public Shape move(Shape s, int dx, int dy) {
        Ellipse2D.Float p = (Ellipse2D.Float) s;
        p.x += dx;
        p.y += dy;
        return p;
    }
}
