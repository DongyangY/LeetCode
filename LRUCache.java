public class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head, end;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    
    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
        
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }
    
    public void setHead(Node n) {
        n.next = head;
        n.pre = null;
        
        if (head != null) {
            head.pre = n;
        }
        
        head = n;
        
        if (end == null) {
            end = head;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        } else {
            Node n = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(n);
            } else {
                setHead(n);
            }
            map.put(key, n);
        }
    }
}