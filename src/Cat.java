import java.awt.Color;

public class Cat extends Actor {
<<<<<<< Updated upstream
  public Cat(Cell inLoc) {
    loc = inLoc;
    color = Color.BLUE;
  }
}
=======
    public Cat(Cell cell) { super(cell); }
    @Override protected Color getColor() { return Color.BLUE; }
}
>>>>>>> Stashed changes
