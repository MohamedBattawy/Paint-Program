package FinalProject;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineMaker extends ShapeMakerStrategy {


    public LineMaker(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
    }

    public Shape make() {
        int x1 = getX1();
        int y1 = getY1();
        int x2 = getX2();
        int y2 = getY2();
        return new Line2D.Float(x2 > x1 ? x1 : x2, x2 > x1 ? y1 : y2, x2 < x1 ? x1 : x2, x2 < x1 ? y1 : y2);
    }
}

