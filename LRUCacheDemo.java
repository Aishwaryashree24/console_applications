import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // access order
        // This is calling the constructor of the superclass LinkedHashMap
        // public LinkedHashMap(int initialCapacity, float loadFactor, boolean
        // accessOrder)
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
    // Every time you add a new entry using .put(), Java internally checks this
    // method.
    // If it returns true, the eldest (oldest) entry is removed from the map
    // automatically.
    // If it returns false, nothing is removed.

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }
    // V is type parameter - placeholder for Value

    public void putValue(K key, V value) {
        super.put(key, value);
    }

    public void printCache() {
        System.out.println("Cache (LRU order): " + this);
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();

        LRUCache<Integer, String> cache = new LRUCache<>(capacity);
        sc.nextLine(); // consume newline

        while (true) {
            System.out.println("\n======================");
            System.out.println("Choose an action:");
            System.out.println("1. put  - Add/Update key");
            System.out.println("2. get  - Retrieve key");
            System.out.println("3. stop - Exit");
            System.out.print("Your choice: ");
            String choice = sc.nextLine().trim().toLowerCase();

            switch (choice) {
                case "put":
                    System.out.print("Enter key (integer): ");
                    int key = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter value (string): ");
                    String value = sc.nextLine();

                    cache.putValue(key, value);
                    System.out.println("Entry added.")
                    cache.printCache();
                    break;

                case "get":
                    System.out.print("Enter key to retrieve: ");
                    int getKey = sc.nextInt();
                    sc.nextLine(); // consume newline

                    String result = cache.getValue(getKey);
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
                        System.out.println("Key not found.");
                    }
                    cache.printCache();
                    break;

                case "stop":
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice. Try 'put', 'get', or 'stop'.");
            }
        }
    }
}
