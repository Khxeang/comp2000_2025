import java.awt.Color;
import java.awt.Polygon;


public class Fish extends Item implements Edible {

    public Fish(Cell loc) {
        super(loc, Color.BLUE);

        Polygon fishBody = new Polygon();
        fishBody.addPoint(5, 15);
        fishBody.addPoint(25, 10);
        fishBody.addPoint(30, 15);
        fishBody.addPoint(25, 20);
        fishBody.addPoint(5, 15);

        Polygon fishTail = new Polygon();
        fishTail.addPoint(30, 15);
        fishTail.addPoint(35, 10);
        fishTail.addPoint(35, 20);

        shapes.add(fishBody);
        shapes.add(fishTail);
    }

    @Override
    public String getItemName() {
        return "Fish";
    }
    
}
