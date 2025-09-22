
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Dog extends Animal {
  private Polygon ear1, ear2, head;

  public Dog(Cell loc) {
    // Updated, now Animal takes in 3 arguments which is location, color and name.
    super(loc, Color.RED, "Dog");

    Polygon ear1 = new Polygon();
    ear1.addPoint(5, 5);
    ear1.addPoint(15, 5);
    ear1.addPoint(5, 15);

    Polygon ear2 = new Polygon();
    ear2.addPoint(20, 5);
    ear2.addPoint(30, 5);
    ear2.addPoint(30, 15);

    Polygon head = new Polygon();
    head.addPoint(5, 15);
    head.addPoint(30, 15);
    head.addPoint(17, 30);
    head.addPoint(8, 25);

    shapes.add(ear1);
    shapes.add(ear2);
    shapes.add(head);

  }
    // New paint method to iterates through each polygon and translates it to the new location
    @Override
    public void paint(Graphics g){
        for (Polygon p : shapes){
            Polygon tempPolygon = new Polygon();
            for (int i = 0; i < p.npoints; i++){
                tempPolygon.addPoint(p.xpoints[i] + loc.x, p.ypoints[i] + loc.y);
            }

            g.setColor(Color.RED);
            g.drawPolygon(tempPolygon);
            g.setColor(color);
            g.fillPolygon(tempPolygon);
        }
    
    }

  @Override
  public String getTargetItem(){
    return "Bone";
  }


}
