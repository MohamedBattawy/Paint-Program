package FinalProject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ColorShape implements Cloneable{
    private Shape shape;

    public ColorShape(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         ColorShape s = (ColorShape) super.clone();
         s.setColor(new Color(this.color.getRGB()));
         Shape shape = this.getShape();
         if (shape instanceof Rectangle2D.Float){
             s.setShape((Shape) ((Rectangle2D.Float) shape).clone());
         }
         else if (shape instanceof Ellipse2D.Float){
             s.setShape((Shape) ((Ellipse2D.Float) shape).clone());
         }
         else if (shape instanceof Line2D.Float){
             s.setShape((Shape) ((Line2D.Float) shape).clone());
         }
         else if (shape instanceof Polygon){
             TriangleMaker t = new TriangleMaker(((Polygon) shape).xpoints[0],((Polygon) shape).xpoints[2],((Polygon) shape).ypoints[1],((Polygon) shape).ypoints[2]);
             s.setShape(t.make());
         }
         return s;
    }

    private Color color;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
