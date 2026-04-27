class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {}
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    private HashMap<Integer, ListNode> cache;
    private int cap;
    private ListNode left;
    private ListNode right;


    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(ListNode node) {
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        ListNode newNode = new ListNode(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > cap) {
            ListNode lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
