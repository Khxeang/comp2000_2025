import java.awt.Color;
import java.awt.Polygon;

public class Grass extends Item implements Edible {

    public Grass(Cell loc) {
        super(loc, Color.GREEN);

        Polygon stalk1 = new Polygon();
        stalk1.addPoint(5, 35);
        stalk1.addPoint(10, 15);
        stalk1.addPoint(15, 35);

        Polygon stalk2 = new Polygon();
        stalk2.addPoint(15, 35);
        stalk2.addPoint(20, 10);
        stalk2.addPoint(25, 35);

        Polygon stalk3 = new Polygon();
        stalk3.addPoint(25, 35);
        stalk3.addPoint(30, 20);
        stalk3.addPoint(35, 35);

        shapes.add(stalk1);
        shapes.add(stalk2);
        shapes.add(stalk3);
    }

    @Override
    public String getItemName() {
        return "Grass";
    }
}