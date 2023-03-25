package FinalProject;

public class Originator {
    private ShapeList list=new ShapeList();

    // Sets the value for the article

    public void set(ShapeList newList) {
        //    System.out.println("From Originator: Current Version of Article\n"+newArticle+ "\n");
        this.list = newList;
    }

    // Creates a new Memento with a new article

    public Memento storeInMemento() {
        System.out.println("From Originator: Saving to Memento");
        return new Memento(list);
    }

    // Gets the article currently stored in memento

    public ShapeList  restoreFromMemento(Memento memento) {

        list = memento.getSavedList();

        // System.out.println("From Originator: Previous Article Saved in Memento\n"+article + "\n");

        return list;

    }
}
