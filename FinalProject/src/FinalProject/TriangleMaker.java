package FinalProject;

import java.awt.*;

public class TriangleMaker extends ShapeMakerStrategy {
    int[]x;
    int[]y;

    public TriangleMaker(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
        x=new int[3];
        y=new int[3];
    }

    public Shape make() {
        int x1 = getX1();
        int y1 = getY1();
        int x2 = getX2();
        int y2 = getY2();
        x[0]=x1;
        x[1]=(x1+x2)/2;
        x[2]=x2;
        y[0]=y2;
        y[1]=y1;
        y[2]=y2;
        return new Polygon(x,y,3);
    }
}
