import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Stage {
    private Grid grid;
    private Animal activeAnimal;
    private ArrayList<Actor> actors;
    private int col = 0;
    private int row = 0;
    private int moveCount = 0; // Track number of moves

    public Stage(String chosenAnimal) {
        grid = new Grid();
        actors = new ArrayList<>();

        // Create the chosen animal at the starting position
        Cell startingCell = grid.cellAtColRow(col, row);
        createAnimal(chosenAnimal, startingCell);

        // Add initial edible item
        addEdibleItem();
    }

    private void createAnimal(String animalType, Cell location) {
        switch (animalType) {
            case "Dog":
                activeAnimal = new Dog(location);
                break;
            case "Cat":
                activeAnimal = new Cat(location);
                break;
            case "Bird":
                activeAnimal = new Bird(location);
                break;
            case "Kangaroo":
                activeAnimal = new Kangaroo(location);
                break;
            default:
                throw new IllegalArgumentException("Unknown animal type: " + animalType);
        }

        actors.add(activeAnimal);
        location.setActor(activeAnimal);
    }

    public void paint(Graphics g, Point mouseLoc) {
        grid.paint(g, mouseLoc);
        // Note: Actors are painted by the grid cells they occupy
    }

    // Adding edible item to the stage
    public void addEdibleItem() {
        if (activeAnimal != null) {
            Edible item = activeAnimal.createNewEdible(grid, activeAnimal);

            if (item != null) {
                actors.add((Actor) item);
            }
        }
    }

    // Method to move selected animal
    public void moveSelectedAnimal(String direction) {
        if (activeAnimal == null) {
            return;
        }

        int newCol = col;
        int newRow = row;
        Cell currentCell = grid.cellAtColRow(col, row);

        // Calculate new position based on direction
        switch (direction) {
            case "UP":
                newRow--;
                break;
            case "DOWN":
                newRow++;
                break;
            case "LEFT":
                newCol--;
                break;
            case "RIGHT":
                newCol++;
                break;
            default:
                return; // Invalid direction
        }

        // Check if the new position is within bounds
        if (newCol >= 0 && newCol < grid.cells.length &&
                newRow >= 0 && newRow < grid.cells[0].length) {

            Cell newCell = grid.cellAtColRow(newCol, newRow);
            Actor actorOnNewCell = newCell.getActor();

            // Check if new cell is empty or contains edible item
            if (actorOnNewCell == null) {
                // Move to empty cell
                moveAnimalToCell(currentCell, newCell, newCol, newRow);
            } else if (actorOnNewCell instanceof Edible) {
                // Check if animal can eat this edible item
                Edible edibleItem = (Edible) actorOnNewCell;
                if (activeAnimal.eat(edibleItem)) {
                    // Animal successfully ate the item, remove it and move
                    actors.remove(actorOnNewCell);
                    moveAnimalToCell(currentCell, newCell, newCol, newRow);
                }
                // If animal cannot eat the item, it cannot move to that cell
            }
        }
    }

    // Helper method to move animal to a new cell
    private void moveAnimalToCell(Cell currentCell, Cell newCell, int newCol, int newRow) {
        // Clear the current cell
        currentCell.setActor(null);

        // Move animal to new cell
        activeAnimal.move(newCell);
        newCell.setActor(activeAnimal);

        // Update position tracking
        col = newCol;
        row = newRow;

        // Increment move count and add edible item every 3 moves
        moveCount++;
        if (moveCount % 3 == 0) {
            addEdibleItem();
        }
    }
}
