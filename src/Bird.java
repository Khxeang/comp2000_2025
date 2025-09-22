
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Bird extends Animal{
  private Polygon wing1, wing2, body;

  public Bird(Cell loc) {
    super(loc, Color.PINK, "Bird");

    Polygon wing1 = new Polygon();
    wing1.addPoint(5, 5);
    wing1.addPoint(15, 17);
    wing1.addPoint(5, 17);

    Polygon wing2 = new Polygon();
    wing2.addPoint(30, 5);
    wing2.addPoint(20, 17);
    wing2.addPoint(30, 17);

    Polygon body = new Polygon();
    body.addPoint(15, 10);
    body.addPoint(20, 10);
    body.addPoint(20, 25);
    body.addPoint(15, 25);

    shapes.add(wing1);
    shapes.add(wing2);
    shapes.add(body);
  }

  @Override
  public void paint(Graphics g){
      for (Polygon p : shapes){
          Polygon tempPolygon = new Polygon();
          for (int i = 0; i < p.npoints; i++){
              tempPolygon.addPoint(p.xpoints[i] + loc.x, p.ypoints[i] + loc.y);
          }

          g.setColor(Color.PINK);
          g.drawPolygon(tempPolygon);
          g.setColor(color);
          g.fillPolygon(tempPolygon);
      }
  
  }

  @Override
  public String getTargetItem(){
    return "Worm";
  }
}
