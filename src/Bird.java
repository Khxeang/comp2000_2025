import java.awt.Color;

public class Bird extends Actor {
<<<<<<< Updated upstream
  public Bird(Cell inLoc) {
    loc = inLoc;
    color = Color.GREEN;
  }
}
=======
    public Bird(Cell cell) { super(cell); }
    @Override protected Color getColor() { return Color.GREEN; }
}
>>>>>>> Stashed changes
