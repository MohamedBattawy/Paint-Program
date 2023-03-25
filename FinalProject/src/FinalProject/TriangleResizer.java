package FinalProject;

import java.awt.*;

public class TriangleResizer implements ShapeResizer {
    public Shape Resize(Shape s, float amount){
        Polygon p = (Polygon) s;
        int newx[] =p.xpoints;
        int newy[] =p.ypoints;
        newx[0]-=amount;
        newx[2]+=amount;
        newy[0]+=amount;
        newy[1]-=amount;
        newy[2]+=amount;
        return p;
    }
}
