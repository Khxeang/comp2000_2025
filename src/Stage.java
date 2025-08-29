import java.awt.Graphics;
import java.awt.Point;

public class Stage {
<<<<<<< Updated upstream
  Grid grid;
  Actor cat;
  Actor dog;
  Actor bird;

  public Stage() {
    grid = new Grid();
    cat = new Cat(grid.cellAtColRow(0, 0));
    dog = new Dog(grid.cellAtColRow(0, 15));
    bird = new Bird(grid.cellAtColRow(12, 9));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    cat.paint(g);
    dog.paint(g);
    bird.paint(g);
  }
=======
    Grid grid = new Grid();
    
    Actor[] actors = {
        new Cat(grid.getCell(5, 5)),
        new Bird(grid.getCell(10, 10)),
        new Dog(grid.getCell(15, 12))  // pick any row/col you like
    };
    

    public void paint(Graphics g, Point mousePos) {
        grid.paint(g, mousePos);     
        for (Actor actor : actors) {     
            actor.paint(g);
        }
    }

>>>>>>> Stashed changes
}
