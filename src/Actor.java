import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class Actor {
    Color color;
    List<Polygon> shapes = new ArrayList<>();
    Cell loc;

    public Actor(Cell loc, Color color){
        this.loc = loc;
        this.color = color;
    }

    //Method to help Animal move on the grid
    public void setLoc(Cell loc){
        this.loc = loc;
    }

    public void paint(Graphics g){
        for(Polygon p : shapes){
            g.setColor(color.BLACK);
            g.drawPolygon(p);
            g.setColor(color);
            g.fillPolygon(p);
        }
    }
}
