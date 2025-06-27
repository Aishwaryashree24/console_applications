import java.util.HashMap;
import java.util.Scanner;

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            // Remove least recently used node
            Node lru = tail.prev;
            remove(lru);
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
    }

    // Remove node from linked list and hashmap
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node right after head (most recently used)
    private void insertToFront(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void printCache() {
        Node curr = head.next;
        System.out.print("Cache (MRU → LRU): ");
        while (curr != tail) {
            System.out.print("(" + curr.key + "=" + curr.value + ") ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cache capacity: ");
        int capacity = scanner.nextInt();
        LRUCache cache = new LRUCache(capacity);
        int choice;

        do{
            System.out.print("Choose an operation: 1) Put 2) Get 3) Print Cache 4) Exit: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = scanner.nextInt();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    cache.put(key, value);
                    System.out.println("Inserted (" + key + "=" + value + ")");
                    break;
                case 2:
                    System.out.print("Enter key to get: ");
                    key = scanner.nextInt();
                    int result = cache.get(key);
                    if (result != -1) {
                        System.out.println("Value for key " + key + ": " + result);
                    } else {
                        System.out.println("Key " + key + " not found.");
                    }
                    break;
                case 3:
                    cache.printCache();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(choice != 4);

        scanner.close();
    }
}

