import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor {
  Color color;
  List<Polygon> shapes = new ArrayList<>();
  Cell loc;

  public Actor(Cell loc, Color color) {
    this.loc = loc;
    this.color = color;
  }

  public void paint(Graphics g){
    for(Polygon p : shapes) {
      g.setColor(color.BLACK);
      g.drawPolygon(p);
      g.setColor(color);
      g.fillPolygon(p);
    }
  }
}
