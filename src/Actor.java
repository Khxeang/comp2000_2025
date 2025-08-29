<<<<<<< Updated upstream
import java.awt.Color;
import java.awt.Graphics;

public abstract class Actor {
  Color color;
  Cell loc;

  public void paint(Graphics g) {
    g.setColor(color);
    g.fillRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
    g.setColor(Color.GRAY);
    g.drawRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
  }
}
=======
import java.awt.*;

public abstract class Actor {
    protected final Cell cell;

    public Actor(Cell cell) {
        this.cell = cell;
    }

    // subclasses must provide their own color
    protected abstract Color getColor();

    // common paint method uses the color
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(cell.x, cell.y, cell.width, cell.height);
    }
}
>>>>>>> Stashed changes
