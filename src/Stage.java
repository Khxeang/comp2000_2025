import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Stage {
  Grid grid;
  Actor cat;
  Actor dog;
  Actor bird;

  ArrayList<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(cat = new Cat(grid.cellAtColRow(0, 0)));
    actors.add(dog = new Dog(grid.cellAtColRow(0, 15)));
    actors.add(bird = new Bird(grid.cellAtColRow(12, 9)));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for (Actor a : actors) {
      a.paint(g);
    }
  }
}
