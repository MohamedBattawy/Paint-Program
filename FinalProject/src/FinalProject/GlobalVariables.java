package FinalProject;

import java.awt.*;

public class GlobalVariables {
    public static Boolean moveFlag =false;
    public static Boolean resizeFlag=false;
    public static Boolean drawFlag=false;
    public static ShapeList shapeList=new ShapeList();
    public static Originator originator =new Originator();
    public  static Caretaker caretaker=new Caretaker();
    public static int currentShape=0;
    public static int redoCount = 0;
    public static Color nextColor;
}
