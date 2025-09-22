import java.awt.Color;
import java.awt.Polygon;

public class Worm extends Item implements Edible {

    public Worm(Cell loc) {
        super(loc, new Color(139, 69, 19)); // Brown color

        Polygon wormBody = new Polygon();
        wormBody.addPoint(10, 15);
        wormBody.addPoint(25, 15);
        wormBody.addPoint(30, 20);
        wormBody.addPoint(25, 25);
        wormBody.addPoint(10, 25);

        shapes.add(wormBody);
    }

    @Override
    public String getItemName() {
        return "Worm";
    }
}