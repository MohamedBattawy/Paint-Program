package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

public class PaintBoard extends JPanel {
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color;
    public PaintBoard(){
        super();
        this.setOpaque(true);
        this.setMinimumSize(new Dimension(800,450));
        this.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Iterator<ColorShape> i = GlobalVariables.shapeList.iterator();
        while (i.hasNext()){
            ColorShape s = i.next();
            g2d.setPaint(s.getColor());
            g2d.setStroke(new BasicStroke(5));
            g2d.draw(s.getShape());
            g2d.fill(s.getShape());
        }
    }

}

