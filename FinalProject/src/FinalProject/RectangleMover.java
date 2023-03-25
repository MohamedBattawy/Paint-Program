package FinalProject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleMover implements ShapeMover {
    @Override
    public Shape move(Shape s, int dx, int dy) {
        Rectangle2D.Float p = (Rectangle2D.Float) s;
        p.x += dx;
        p.y += dy;
        return p;
    }

}
