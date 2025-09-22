
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Cat extends Animal {
  private Polygon ear1, ear2, head;

  public Cat(Cell loc) {
    super(loc, Color.BLUE, "Cat");

    Polygon ear1 = new Polygon();
    ear1.addPoint(11, 5);
    ear1.addPoint(15, 15);
    ear1.addPoint(7, 15);


    Polygon ear2 = new Polygon();
    ear2.addPoint(22, 5);
    ear2.addPoint(26, 15);
    ear2.addPoint(18, 15);


    Polygon head = new Polygon();
    head.addPoint(5, 15);
    head.addPoint(29, 15);
    head.addPoint(17, 30);

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

          g.setColor(Color.BLUE);
          g.drawPolygon(tempPolygon);
          g.setColor(color);
          g.fillPolygon(tempPolygon);
      }
  
  }
}
