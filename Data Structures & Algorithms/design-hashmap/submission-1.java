class MyHashMap {

    class ListNode{
        int key;
        int value;
        ListNode next;

        public ListNode(){
            this.key = 0;
            this.value = 0;
            this.next = null;
        }

        public ListNode(int k, int v){
            this.key = k;
            this.value = v;    
        }

        public void setNextNode(ListNode n){
            this.next = n;
        }
    }
    ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[1000];
        for(int i = 0;i < 1000; i++){
            buckets[i] = new ListNode();
        }
    }
    
    public void put(int key, int value) {
        ListNode temp = buckets[key%1000];
        while(temp.next != null){
            if(temp.next.key == key){
                temp.next.value = value;
                return;
            }
            temp = temp.next;
        }
        temp.next = new ListNode(key,value);
    }
    
    public int get(int key) {
        ListNode temp = buckets[key%1000];
        while(temp.next != null){
            if(temp.next.key == key){
                return temp.next.value;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode temp = buckets[key%1000];
        while(temp.next != null){
            if(temp.next.key == key){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */