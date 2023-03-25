package FinalProject;

import java.awt.*;

public class TriangleMover implements ShapeMover{
    public Shape move(Shape s, int dx, int dy) {
        Polygon p = (Polygon) s;
        p.translate(dx, dy);
        return p;
    }
}
