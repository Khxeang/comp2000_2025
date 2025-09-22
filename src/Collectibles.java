import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Collectibles<T extends Edible> {
    private final List<T> items;

    public Collectibles() {
        this.items = new ArrayList<>();
    }

    public void collectItem(T item) {
        items.add(item);
        printInventory();
    }

    public List<T> getItems() {
        return new ArrayList<>(items); // Return a copy to prevent external modification
    }

    public void printInventory() {
        if (items.isEmpty()) {
            System.out.println("No items collected yet.");
            return;
        }

        Map<String, Integer> counts = new LinkedHashMap<>();
        for (T item : items) {
            String name = item.getClass().getSimpleName();
            counts.put(name, counts.getOrDefault(name, 0) + 1);
        }

        counts.forEach((name, count) -> System.out.println("collected " + name + " * " + count));
    }
}