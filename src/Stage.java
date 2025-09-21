import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Stage {
    Grid grid;
    Actor cat;
    Actor dog;
    Actor bird;

    ArrayList<Actor> actors;

    public void paint(Graphics g, Point mouseLoc){
        grid.paint(g, mouseLoc);
        for (Actor a : actors){
            a.paint(g);
        }
    }


    //Only Spawn in chosen animal
    public Stage(String chosenAnimal) {
        grid = new Grid();
        actors = new ArrayList<>();

        if(chosenAnimal.equals("Dog")){
            dog = new Dog(grid.cellAtColRow(1, 0));
            actors.add(dog);
        } else if (chosenAnimal.equals("Cat")){
            cat = new Cat(grid.cellAtColRow(1, 0));
            actors.add(cat);
        } else if (chosenAnimal.equals("Bird")){
            bird = new Bird(grid.cellAtColRow(3, 0));
            actors.add(bird);
        }

    
    }

}
