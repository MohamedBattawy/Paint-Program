package FinalProject;

import java.awt.*;

import static java.lang.Math.abs;

public class TrianglePaster implements ShapePaster{
    public Shape paste(Shape s, int dx, int dy) {
        Polygon p = (Polygon) s;
        int length,height;
        int x[]=p.xpoints;
        int y[]=p.ypoints;
        length=abs(x[0]-x[2]);
        height=abs(y[0]-y[1]);
        x[0]=dx;
        x[1]=x[0]+(length/2);
        x[2]=x[0]+length;
        y[0]=dy;
        y[1]=dy-height;
        y[2]=dy;
        return p;
    }

}
