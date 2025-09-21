import java.awt.Color;

public abstract class Animal extends Actor {
    protected String name;

    public Animal(Cell loc, Color color, String name) {
        super(loc, color);
        this.name = name;
    }

    // Each animal will have a specific item that it can pick up
    public abstract String getTargetItem();
        
    // Method to move the animal to a new location
    public void move(Cell newLoc){
        setLoc(newLoc);
    }
}
