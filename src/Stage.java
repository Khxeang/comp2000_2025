import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Stage {
    Grid grid;
    Actor activeAnimal;

    ArrayList<Actor> actors;
    int col = 0;
    int row = 0;

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
            Dog dog = new Dog(grid.cellAtColRow(col, row));
            actors.add(dog);
            activeAnimal = dog;
        } else if (chosenAnimal.equals("Cat")){
            Cat cat = new Cat(grid.cellAtColRow(col, row));
            actors.add(cat);
            activeAnimal = cat;
        } else if (chosenAnimal.equals("Bird")){
            Bird bird = new Bird(grid.cellAtColRow(col, row));
            actors.add(bird);
            activeAnimal = bird;
        } else if (chosenAnimal.equals("Kangaroo")){
            Kangaroo kangaroo = new Kangaroo(grid.cellAtColRow(col,row));
            actors.add(kangaroo);
            activeAnimal = kangaroo;
        }

    
    }

    //Method to move selected animal
    public void moveSelectedAnimal(String direction){
        int newCol = col;
        int newRow = row;

        if(direction.equals("UP")){
            newRow--;
        } else if (direction.equals("DOWN")){
            newRow++;
        } else if (direction.equals("LEFT")){
            newCol--;
        } else if (direction.equals("RIGHT")){
            newCol++;
        }

        // Prevent moving out of bounds
        if (newCol >= 0 && newCol < grid.cells.length && newRow >= 0 && newRow < grid.cells[0].length) {
            col = newCol;
            row = newRow;
            Cell newLoc = grid.cellAtColRow(col, row);
            if (activeAnimal instanceof Animal) {
                ((Animal) activeAnimal).setLoc(newLoc);
            }
        }
    }
}
