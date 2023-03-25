package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CirclePaster implements ShapePaster {
    public Shape paste(Shape s, int dx, int dy) {
        Ellipse2D.Float p = (Ellipse2D.Float) s;
        p.x = dx;
        p.y = dy;
        return p;
    }
}
