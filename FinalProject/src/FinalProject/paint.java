package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class paint extends JFrame {

    private static paint instance = null;
    private JPanel panel1;
    private JButton undoButton;
    private PaintBoard paintBoard1;
    private JRadioButton drawLineRadioButton;
    private JRadioButton drawTriangleRadioButton;
    private JRadioButton drawSquareRadioButton;
    private JRadioButton drawRectangleRadioButton;
    private JRadioButton drawCircleRadioButton;
    private JRadioButton copyRadioButton;
    private JRadioButton deleteRadioButton;
    private JRadioButton resizeRadioButton;
    private JRadioButton moveRadioButton;
    private JButton redoButton;
    private myColorChooser myColorChooser1;
    private JRadioButton modifyColorRadioButton;
    private ButtonGroup buttonGroup1;
    private ActionListener actionListener;
    private MouseAdapter mouseAdapter;

public static paint getInstance(){
    if(instance==null) instance = new paint();
    return instance;
}
    private paint() {
        GlobalVariables.originator.set((ShapeList) GlobalVariables.shapeList.clone());
        GlobalVariables.caretaker.addMemento(GlobalVariables.currentShape,GlobalVariables.originator.storeInMemento());
        JFrame frame = new JFrame("Paint");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        redoButton.setEnabled(false);
        undoButton.setEnabled(true);
        myColorChooser1.setColor(Color.BLACK);
       drawLineRadioButton.setActionCommand("draw line");
        drawTriangleRadioButton.setActionCommand("draw triangle");
        drawSquareRadioButton.setActionCommand("draw square");
        drawRectangleRadioButton.setActionCommand("draw rectangle");
        drawCircleRadioButton.setActionCommand("draw circle");
        copyRadioButton.setActionCommand("copy");
        deleteRadioButton.setActionCommand("delete");
        resizeRadioButton.setActionCommand("resize");
        moveRadioButton.setActionCommand("move");
        modifyColorRadioButton.setActionCommand("modify color");

        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redoButton.setEnabled(false);
                GlobalVariables.redoCount = 0;
                undoButton.setEnabled(true);
                GlobalVariables.redoCount++;
                GlobalVariables.nextColor=myColorChooser1.getColor();
                paintBoard1.removeMouseListener(mouseAdapter);
                paintBoard1.removeMouseMotionListener(mouseAdapter);
                paintBoard1.removeMouseWheelListener(mouseAdapter);
                mouseAdapter = new AdapterFactory().createMouseAdapter(buttonGroup1.getSelection().getActionCommand());
                paintBoard1.addMouseListener(mouseAdapter);
                paintBoard1.addMouseMotionListener(mouseAdapter);
                paintBoard1.addMouseWheelListener(mouseAdapter);
            }
        };

        drawLineRadioButton.addActionListener(actionListener);
        drawTriangleRadioButton.addActionListener(actionListener);
        drawSquareRadioButton.addActionListener(actionListener);
        drawRectangleRadioButton.addActionListener(actionListener);
        drawCircleRadioButton.addActionListener(actionListener);
        copyRadioButton.addActionListener(actionListener);
        deleteRadioButton.addActionListener(actionListener);
        resizeRadioButton.addActionListener(actionListener);
        moveRadioButton.addActionListener(actionListener);
        modifyColorRadioButton.addActionListener(actionListener);


        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(GlobalVariables.currentShape>0){
                    GlobalVariables.currentShape--;
                    System.out.println("undo done " + GlobalVariables.currentShape);
                    GlobalVariables.shapeList=  GlobalVariables.originator.restoreFromMemento(GlobalVariables.caretaker.getMemento(GlobalVariables.currentShape));
                    paintBoard1.repaint();
                    redoButton.setEnabled(true);
                    GlobalVariables.redoCount ++;
                }
                else undoButton.setEnabled(false);
            }
        });

        redoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(GlobalVariables.redoCount == 1){
                    redoButton.setEnabled(false);
                    return;
                }
                    GlobalVariables.currentShape++;
                    GlobalVariables.redoCount--;
                    System.out.println("redo done " + GlobalVariables.currentShape);
                    GlobalVariables.shapeList=  GlobalVariables.originator.restoreFromMemento(GlobalVariables.caretaker.getMemento(GlobalVariables.currentShape));
                    paintBoard1.repaint();
                System.out.println(GlobalVariables.redoCount);
            }
        });
    }
    public static void main(String[] args) {
        paint.getInstance();
    }


}