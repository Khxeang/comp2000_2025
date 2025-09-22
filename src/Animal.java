import java.awt.Color;
import java.util.Random;

public abstract class Animal extends Actor {
    protected String name;
    protected Random random = new Random();

    public Animal(Cell loc, Color color, String name) {
        super(loc, color);
        this.name = name;
    }

    // Method to move the animal to a new location
    public void move(Cell newLoc) {
        setLoc(newLoc);
    }

    // Each animal will be able to eat the item upon landing on it on the grid
    public boolean eat(Edible item) {
        // Check if the animal can eat this specific item
        if (canEat(item)) {
            System.out.println(name + " ate a " + item.getItemName());
            return true; // Successfully ate the item
        } else {
            System.out.println(name + " cannot eat " + item.getItemName());
            return false; // Cannot eat this item
        }
    }

    // Method to check if the animal can eat the specific food type
    private boolean canEat(Edible item) {
        String itemName = item.getItemName();

        switch (name) {
            case "Dog":
                return itemName.equals("Bone");
            case "Cat":
                return itemName.equals("Fish");
            case "Bird":
                return itemName.equals("Worm");
            case "Kangaroo":
                return itemName.equals("Grass");
            default:
                return false; // Unknown animal type cannot eat anything
        }
    }

    public void showInventory(){
        System.out.println(name + "'s Inventory:");
    }

    public Edible createNewEdible(Grid grid, Actor currentActor) {
        int c = random.nextInt(grid.cells.length);
        int r = random.nextInt(grid.cells[0].length);
        Cell newLoc = grid.cellAtColRow(c, r);

        // Ensure the new location is not occupied by another actor and not the same as
        // current actor's location
        while (newLoc.getActor() != null || newLoc == currentActor.loc) {
            c = random.nextInt(grid.cells.length);
            r = random.nextInt(grid.cells[0].length);
            newLoc = grid.cellAtColRow(c, r);
        }

        // Create a random edible item
        Edible newEdible = createRandomEdible(newLoc);

        // Place the new edible item in the empty cell
        newLoc.setActor((Actor) newEdible);

        return newEdible;
    }

    // Helper method to create a random edible item
    private Edible createRandomEdible(Cell loc) {
        int edibleType = random.nextInt(4); // 0-3 for 4 different edible types

        switch (edibleType) {
            case 0:
                return new Worm(loc);
            case 1:
                return new Grass(loc);
            case 2:
                return new Fish(loc);
            case 3:
                return new Bone(loc);
            default:
                return new Worm(loc); // Default fallback
        }
    }
}
