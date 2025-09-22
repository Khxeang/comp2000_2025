# COMP2000 - Assignment 1
In this assignment I am demonstrating:  my git proficiency, my java proficiency, my understanding of inheritance, interfaces, and generics.


# 🐾 Grid Game Assignment – COMP2000
    Project Overiew:
        This project was set out to extend the Week 5 activity grid-based starter code into a mini-game featuring animals, and some collectible items on the grid. Each animal which includes Dog, Cat, Bird, and Kangaroo can move across a grid, targeting and eating its assigned edible item such as Bone, Fish, Worm, and Grass. Items are generated randomly and placed into empty cells, everytime the user moves, more random items spawns all over the game canvas in a random grid position. The game supports dynamic interaction between animals, and items.


# Main Functionality Overview
    🐶 Animal Specialization: Dog, Cat, Bird, and Kangaroo are subclasses of a shared Animal superclass. Each can only eat its assigned item.
        - Dog eats Bones (Red item)
        - Cat eats Fish (Blue item)
        - Bird eats Worms (Brown Item)
        - Kangaroo eats Grass (Green Item).

    🍖 Edible Items: Bone, Fish, Worm, and Grass are edible items scattered across the grid. This is an implementation of Edible interface and inherit from the Item base class.

    🎒 Inventory System (Generics): Each Animal has an Inventory<Edible> that stores collected items using a generic class to keep track of the item they eat/collected.

    🧩 Game Flow: The game will initially start with a main menu that lets players choose their animal to play as. The game then will populate the grid and runs game logic that lets animal move, find items, and collect them if its their designated item, if it's not the animal will be blocked and can't move over the grid.


# Object-Oriented Concpets Demonstrated - Use Of Inheritance
I have used inheritance to create a clear and organized hierarchy of objects in my simple game. The use of inheritance allowed me to defind a general base class with common features and then create a more specific subclasses that inherit those features and add their own unique logic and characteristics.

Inheritance is used to generalize and reuse behavior:

    Base Class:                         Subclassses
        - Animal                            - Dog, Cat, Bird, Kangaroo
        - Item                              - Bone, Fish, Worm, Grass

    Each subclass overrides methods like getTargetItem() or getItemName() to customize their behavior, characterics, and logic while sharing movement, inventory, and interaction logic.

# Use Of Interfaces
This project defines Edible as an interface that all edible items implement:

    public interface Edible extends Item {
        String getItemName();
    }

This enables animals to interact with items using shared behavior, without needing to know which exact item they're interacting with. This makes the code extensible, scalable so new edible items can be added with minimal code adjustments.


## Use Of Generics
The Inventory <T extends Item> class uses Java generics to enable type-safe inventory tracking:

    public class Inventory<T extends Item> {
        private List<T> items = new ArrayList<>();
        etc......(rest of code)
    }

Animals instantiate this as Inventory<Edible> so they can keep track of their valid edible items. This demonstrates:
    + Type safety without casting
    + Reusability across different item types
    + Appropiate use of generic constraints (T extends Item)

## Key Classes
    ├── Animal.java 
│   ├── Dog.java
│   ├── Cat.java
│   ├── Bird.java
│   └── Kangaroo.java
├── Item.java (base)
│   ├── Bone.java
│   ├── Fish.java
│   ├── Worm.java
│   └── Grass.java
├── Edible.java (interface)
├── Inventory.java (generic class)
├── Cell.java (terrain)
├── Grid.java / Stage.java / Menu.java (engine & GUI)
└── Main.java (entry point)

# 🖥️ How to Compile and Run

    - Java 11 or Java 21 is required (no external libraries required).

    Compile: javac *.java
    Run: from java Main

Once you run the program, you will see a menu to choose your animal. Use keyboard inputs (WASD) to move your animal and collect it designated items.

    + W = Move Up
    + A = Move Left
    + S = Move Down
    + D = Move Right



