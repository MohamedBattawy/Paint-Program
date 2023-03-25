package FinalProject;

import java.awt.event.MouseAdapter;

public class AdapterFactory {
    public MouseAdapter createMouseAdapter(String s){
        switch (s){
            case "draw line":
            case "draw rectangle":
            case "draw square":
            case "draw triangle":
            case "draw circle":
                return new DrawAdapter(s);
            case "move": return new MoveAdapter();
            case "resize": return new ResizeAdapter();
            case "delete": return new DeleteAdapter();
            case "copy": return new CopyAdapter();
            case "modify color": return new ColorAdapter();
        }
        return null;
    }
}
