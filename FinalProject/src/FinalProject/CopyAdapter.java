package FinalProject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ListIterator;

public class CopyAdapter extends MouseAdapter {
    public CopyAdapter() {
        super();
    }

    int xClick, yClick, xClick2, yClick2;
    boolean found = false;
    ColorShape colorShape;
    ColorShape copy;

    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        GlobalVariables.shapeList = (ShapeList) GlobalVariables.shapeList.clone();
        xClick = e.getX();
        yClick=e.getY();
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("left button clicked");
            ListIterator<ColorShape> i = GlobalVariables.shapeList.listIterator(GlobalVariables.shapeList.size());
            while (i.hasPrevious()) {
                colorShape = i.previous();
                if ((colorShape.getShape().getBounds2D().contains(xClick, yClick) && colorShape.getShape() instanceof Line2D.Float) || colorShape.getShape().contains(xClick, yClick)) {
                    found = true;
                    break;
                }
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("right button clicked");
            if (found) {
                try {
                    copy = (ColorShape) colorShape.clone();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
                System.out.println("found");
                xClick2=e.getX();
                yClick2=e.getY();
                int dx = e.getX() - xClick;
                int dy = e.getY() - yClick;
                ShapePaster o = new ShapePasterFactory().createShapePaster(colorShape.getShape()) ;
                copy.setShape(o.paste(copy.getShape(),xClick2,yClick2));
                GlobalVariables.shapeList.add(copy);
                e.getComponent().repaint();
                //Saving in memento for undo redo
                GlobalVariables.originator.set((ShapeList) GlobalVariables.shapeList.clone());
                System.out.println("Added to memento");
                GlobalVariables.currentShape++;
                GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape,GlobalVariables.originator.storeInMemento());
                System.out.println(GlobalVariables.currentShape);
            }
        }
    }
}
