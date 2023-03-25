package FinalProject;

import java.util.ArrayList;

public class Caretaker {
   private ArrayList<Memento> savedShapeLists = new ArrayList<>();

    // Adds memento to the ArrayList

    public void addMemento(int index,Memento m) {
        System.out.println(index + " " + savedShapeLists.size());
        System.out.println(index>savedShapeLists.size());
        if (index < savedShapeLists.size()) {
            savedShapeLists.add(index,m);
            System.out.println("this is the if");
        } else { savedShapeLists.add(m);
            System.out.println("this is the else");
        }
        System.out.println("memento added at index" + savedShapeLists.indexOf(m));
    }

    // Gets the memento requested from the ArrayList

    public Memento getMemento(int index) {
        return savedShapeLists.get(index);
    }
}
