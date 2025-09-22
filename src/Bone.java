import java.awt.Color;
import java.awt.Polygon;


public class Bone extends Item implements Edible {

    public Bone(Cell loc) {
        super(loc, Color.RED);

        Polygon bone = new Polygon();
        bone.addPoint(5, 10);
        bone.addPoint(10, 5);
        bone.addPoint(15, 5);
        bone.addPoint(20, 10);
        bone.addPoint(15, 15);
        bone.addPoint(10, 15);

        shapes.add(bone);
    }

    @Override
    public String getItemName() {
        return "Bone";
    }
    
}
