package FinalProject;

import java.util.Iterator;
import java.util.LinkedList;

public class ShapeList  extends LinkedList<ColorShape> implements Cloneable {

        public Object clone() {
            ShapeList copy = (ShapeList) super.clone();
            copy.clear();
            Iterator<ColorShape> i = this.iterator();
            while (i.hasNext()){
                try {
                    copy.add((ColorShape) i.next().clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            }
        return copy;
    }
}