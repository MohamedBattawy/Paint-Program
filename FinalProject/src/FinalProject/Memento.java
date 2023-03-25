package FinalProject;

public class Memento  {
    private ShapeList shapeLinkedList;



    public Memento(ShapeList shapeListSave) {
        shapeLinkedList = new ShapeList();
        shapeLinkedList = shapeListSave;
    }


    public ShapeList getSavedList() { return shapeLinkedList; }
}
