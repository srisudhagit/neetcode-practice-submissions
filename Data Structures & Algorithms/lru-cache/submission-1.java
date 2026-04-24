 class DLLNode{
        int key;
        int val;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
}

class LRUCache {
    int currCap;
    DLLNode start,end;
    HashMap<Integer, DLLNode> hmap;

    public LRUCache(int capacity) {
        this.hmap = new HashMap<>();
        this.currCap = capacity;
        this.start = new DLLNode(0,0);
        this.end = new DLLNode(0,0);
        this.start.next = this.end;
        this.end.prev = this.start;
    }
    
    public void insert(DLLNode node){
        DLLNode after = this.start.next;
        after.prev = node;
        node.next = after;
        this.start.next = node;
        node.prev = this.start;
    }

    public void remove(DLLNode node){
        DLLNode before = node.prev;
        DLLNode after = node.next;
        before.next = after;
        after.prev = before;
    }

    public int get(int key) {
        if(hmap.containsKey(key)){
            DLLNode node = hmap.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            remove(hmap.get(key));
        }
        DLLNode newnode = new DLLNode(key, value);
        hmap.put(key, newnode);
        insert(newnode);

        if(hmap.size() > this.currCap){
            DLLNode delNode = this.end.prev;
            remove(delNode);
            hmap.remove(delNode.key);
        }
    }
}
