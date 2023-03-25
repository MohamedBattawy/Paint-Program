package FinalProject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;

public class SquareMaker extends ShapeMakerStrategy {


    public SquareMaker(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
    }

    public Shape make() {
        int x1 = getX1();
        int y1 = getY1();
        int x2 = getX2();
        int y2 = getY2();
        return new Rectangle2D.Float(x2>x1?x1:x1-abs(y2-y1),y2>y1?y1:y1-abs(y2-y1),abs(y2-y1),abs(y2-y1));
    }
}
