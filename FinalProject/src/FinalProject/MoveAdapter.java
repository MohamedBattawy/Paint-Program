package FinalProject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ListIterator;

public class MoveAdapter extends MouseAdapter {
    int xPress,yPress;
    ColorShape s;
    boolean isdragged = false;
    public MoveAdapter() {
        super();
    }
    public void mousePressed(MouseEvent e){
        super.mousePressed(e);
        GlobalVariables.shapeList = (ShapeList) GlobalVariables.shapeList.clone();
        xPress = e.getX();
        yPress = e.getY();
        ListIterator<ColorShape> i = GlobalVariables.shapeList.listIterator(GlobalVariables.shapeList.size());
        while(i.hasPrevious()){
            s=i.previous();
            if((s.getShape().getBounds2D().contains(xPress, yPress) && s.getShape() instanceof Line2D.Float) || s.getShape().contains(xPress,yPress)) break;
        }
    }
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        int xDrag = e.getX();
        int yDrag = e.getY();
        int dx = e.getX() - xPress;
        int dy = e.getY() - yPress;
        ShapeMover o = new ShapeMoverFactory().createShapeMover(s.getShape()) ;
        if ((s.getShape().getBounds2D().contains(xPress, yPress) && s.getShape() instanceof Line2D.Float) || s.getShape().contains(xPress,yPress))  {
            s.setShape(o.move(s.getShape(),dx,dy));
            e.getComponent().repaint();
        }
        xPress += dx;
        yPress += dy;
        isdragged = true;
    }
    public void mouseReleased(MouseEvent e){
        if(isdragged) {
            GlobalVariables.originator.set(GlobalVariables.shapeList);
            System.out.println("Added to memento");
            GlobalVariables.currentShape++;
            GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape, GlobalVariables.originator.storeInMemento());
            System.out.println(GlobalVariables.currentShape);
        }}
}