import java.awt.Color;

public class Dog extends Actor {
<<<<<<< Updated upstream
  public Dog(Cell inLoc) {
    loc = inLoc;
    color = Color.YELLOW;
  }
}
=======
    public Dog(Cell cell) { super(cell); }
    
    @Override protected Color getColor() { return Color.YELLOW; }
}
>>>>>>> Stashed changes
