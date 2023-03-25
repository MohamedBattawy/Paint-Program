package FinalProject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawAdapter extends MouseAdapter {
    String type;
    Shape s;
    int x1,x2,y1,y2;
    boolean isdragged= false;
    public DrawAdapter(String type) {
        super();
        this.type=type;
    }
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        x2=e.getX();
        y2=e.getY();
        ColorShape colorShape = GlobalVariables.shapeList.pollLast();
        colorShape.setShape(new ShapeMakerFactory().createShapeMaker(type,x1,x2,y1,y2).make());
        GlobalVariables.shapeList.addLast(colorShape);
        e.getComponent().repaint();
        isdragged = true;
    }
    public void mousePressed(MouseEvent e){
        GlobalVariables.shapeList = (ShapeList) GlobalVariables.shapeList.clone();
        super.mousePressed(e);
        this.x1=e.getX();
        this.y1=e.getY();
        new ShapeMakerFactory().createShapeMaker(type,x1,x2,y1,y2).make();
        GlobalVariables.shapeList.addLast(new ColorShape(s,GlobalVariables.nextColor));
    }
    public void mouseReleased(MouseEvent e){
        if (isdragged){
            GlobalVariables.originator.set( GlobalVariables.shapeList);
            System.out.println("Added to memento");
        GlobalVariables.currentShape++;
        GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape,GlobalVariables.originator.storeInMemento());
            System.out.println(GlobalVariables.currentShape);

        }
          else GlobalVariables.shapeList.removeLast();
    }
    }

