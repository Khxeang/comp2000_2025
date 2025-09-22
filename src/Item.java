import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public abstract class Item extends Actor {
    
    public Item(Cell loc, Color color) {
        super(loc, color);
    }

    public void paint(Graphics g){
        for(Polygon p : shapes){
            Polygon tempPolygon = new Polygon();
            for(int i = 0; i < p.npoints; i++){
                tempPolygon.addPoint(p.xpoints[i] + loc.x, p.ypoints[i] + loc.y);
            }

            g.setColor(color);
            g.fillPolygon(tempPolygon);
            g.setColor(Color.BLACK);
            g.drawPolygon(tempPolygon);
        }
    }
}
