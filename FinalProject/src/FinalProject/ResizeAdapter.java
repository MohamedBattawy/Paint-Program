package FinalProject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Line2D;
import java.util.ListIterator;

public class ResizeAdapter extends MouseAdapter {
    int xPress,yPress;
    ColorShape s;
    public ResizeAdapter() {
        super();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
        GlobalVariables.shapeList = (ShapeList) GlobalVariables.shapeList.clone();
        xPress = e.getX();
        yPress = e.getY();

            ListIterator<ColorShape> i = GlobalVariables.shapeList.listIterator(GlobalVariables.shapeList.size());
            while (i.hasPrevious()) {
                s = i.previous();
                if((s.getShape() instanceof Line2D.Float && s.getShape().getBounds2D().contains(xPress, yPress)) || s.getShape().contains(xPress,yPress)) break;
            }
        ShapeResizer o = new ShapeResizerFactory().createShapeResizer(s.getShape());
            if ((s.getShape().getBounds2D().contains(xPress, yPress) && s.getShape() instanceof Line2D.Float) || s.getShape().contains(xPress,yPress)) {
                float amount = e.getWheelRotation() * 5f;
                s.setShape(o.Resize(s.getShape(), amount));
                e.getComponent().repaint();
            }
        GlobalVariables.originator.set( GlobalVariables.shapeList);
        System.out.println("Added to memento");
        GlobalVariables.currentShape++;
        GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape,GlobalVariables.originator.storeInMemento());
        System.out.println(GlobalVariables.currentShape);
    }

}
