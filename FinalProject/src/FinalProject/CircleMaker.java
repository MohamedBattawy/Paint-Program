package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.lang.Math.abs;

public class CircleMaker extends ShapeMakerStrategy {


    public CircleMaker(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
    }

    public Shape make() {
        int x1 = getX1();
        int y1 = getY1();
        int x2 = getX2();
        int y2 = getY2();
        return new Ellipse2D.Float(x2 > x1 ? x1 : x2, y2 > y1 ? y1 : y2, abs(x2 - x1), abs(x2 - x1));
    }
}
