class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = this.cache.get(key);
            this.remove(node);
            this.insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.remove(cache.get(key));
        }
        Node node = new Node(key, value);
        this.cache.put(key, node);
        this.insert(node);

        if (this.cache.size() > this.capacity) {
            Node leastUsed = this.left.next;
            this.remove(leastUsed);
            this.cache.remove(leastUsed.key);
        }
    }
}

public class Node {
    private int key;
    private int value;
    private Node prev;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
