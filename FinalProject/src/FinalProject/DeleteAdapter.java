package FinalProject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

public class DeleteAdapter extends MouseAdapter {
    ColorShape s;
    int xClick , yClick;
    public DeleteAdapter() {
        super();
    }
    public void mouseClicked (MouseEvent e){
        super.mouseClicked(e);
       GlobalVariables.shapeList = (ShapeList) GlobalVariables.shapeList.clone();
        xClick=e.getX();
        yClick=e.getY();
        boolean found = false;
        ListIterator<ColorShape> i = GlobalVariables.shapeList.listIterator(GlobalVariables.shapeList.size());
        while(i.hasPrevious()){
            s=i.previous();
            if(s.getShape().getBounds().contains(xClick,yClick)) {
                found = true;
                break;
            }
        }
        if (found){GlobalVariables.shapeList.remove(s);
        e.getComponent().repaint();
        //undo redo operation
            GlobalVariables.originator.set(GlobalVariables.shapeList);
            System.out.println("Added to memento");
            GlobalVariables.currentShape++;
            GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape,GlobalVariables.originator.storeInMemento());
            System.out.println(GlobalVariables.currentShape);
        }
        System.out.println("mouse clicked");
    }
}
