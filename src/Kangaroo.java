import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Kangaroo extends Animal {
    private Polygon ear1, ear2, head, body;

    public Kangaroo(Cell loc) {
        super(loc, Color.ORANGE, "Kangaroo");

        Polygon ear1 = new Polygon();
        ear1.addPoint(10, 5);
        ear1.addPoint(15, 0);
        ear1.addPoint(20, 10);

        Polygon ear2 = new Polygon();
        ear2.addPoint(25,10);
        ear2.addPoint(30, 0);
        ear2.addPoint(35,0);

        Polygon head = new Polygon();
        head.addPoint(5,15);
        head.addPoint(40,15);
        head.addPoint(35,35);
        head.addPoint(10,35);

        Polygon body = new Polygon();
        body.addPoint(15, 30);
        body.addPoint(30, 30);
        body.addPoint(22, 40);

        shapes.add(ear1);
        shapes.add(ear2);
        shapes.add(head);
        shapes.add(body);
    }

    //New paint method to iterates through each polygon and translates it to the new location
    @Override
    public void paint(Graphics g){
        for (Polygon p : shapes){
            Polygon tempPolygon = new Polygon();
            for (int i = 0; i < p.npoints; i++){
                tempPolygon.addPoint(p.xpoints[i] + loc.x, p.ypoints[i] + loc.y);
            }

            g.setColor(Color.ORANGE);
            g.drawPolygon(tempPolygon);
            g.setColor(color);
            g.fillPolygon(tempPolygon);
        }
    
    }


    @Override
    public String getTargetItem(){
        return "Grass";
    }
}
