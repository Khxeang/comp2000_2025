import java.awt.Color;
import java.awt.Polygon;

public class Dog extends Actor {
  public Dog(Cell loc) {
    super(loc, Color.RED);

    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);


    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 20, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 15);

    Polygon head = new Polygon();
    head.addPoint(loc.x + 5, loc.y + 15);
    head.addPoint(loc.x + 30, loc.y + 15);
    head.addPoint(loc.x + 17, loc.y + 30);
    head.addPoint(loc.x + 8, loc.y + 25);

    shapes.add(ear1);
    shapes.add(ear2);
    shapes.add(head);

  }
}
