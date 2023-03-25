package FinalProject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ListIterator;

public class ColorAdapter extends MouseAdapter {
    public ColorAdapter(){
        super();
    }
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        GlobalVariables.shapeList = (ShapeList) GlobalVariables.shapeList.clone();
        boolean found=false;
        int xClick=e.getX();
        int yClick=e.getY();
        ColorShape colorShape;
        ListIterator<ColorShape> i = GlobalVariables.shapeList.listIterator(GlobalVariables.shapeList.size());
        while (i.hasPrevious()) {
            colorShape = i.previous();
            if ((colorShape.getShape().getBounds2D().contains(xClick, yClick) && colorShape.getShape() instanceof Line2D.Float) || colorShape.getShape().contains(xClick, yClick)){
                colorShape.setColor(GlobalVariables.nextColor);
                e.getComponent().repaint();
                //undo redo operation
                    GlobalVariables.originator.set(GlobalVariables.shapeList);
                    System.out.println("Added to memento");
                GlobalVariables.currentShape++;
                GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape,GlobalVariables.originator.storeInMemento());
                System.out.println(GlobalVariables.currentShape);
                break;

        }
        }
    }
}
