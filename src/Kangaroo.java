import java.awt.Color;
import java.awt.Polygon;

public class Kangaroo extends Animal {
    public Kangaroo(Cell loc) {
        super(loc, Color.ORANGE, "Kangaroo");

        Polygon ear1 = new Polygon();
        ear1.addPoint(loc.x + 10, loc.y + 5);
        ear1.addPoint(loc.x + 15, loc.y + 0);
        ear1.addPoint(loc.x + 20, loc.y + 10);

        Polygon ear2 = new Polygon();
        ear2.addPoint(loc.x + 25, loc.y + 10);
        ear2.addPoint(loc.x + 30, loc.y + 0);
        ear2.addPoint(loc.x + 35, loc.y + 10);

        Polygon head = new Polygon();
        head.addPoint(loc.x + 5, loc.y + 15);
        head.addPoint(loc.x + 40, loc.y + 15);
        head.addPoint(loc.x + 35, loc.y + 35);
        head.addPoint(loc.x + 10, loc.y + 35);

        Polygon body = new Polygon();
        body.addPoint(loc.x + 15, loc.y + 30);
        body.addPoint(loc.x + 30, loc.y + 30);
        body.addPoint(loc.x + 22, loc.y + 40);

        shapes.add(ear1);
        shapes.add(ear2);
        shapes.add(head);
        shapes.add(body);
    }

    @Override
    public String getTargetItem(){
        return "Grass";
    }
}
