class MyHashSet {

    private static class ListNode{
        int key;
        ListNode next;

        ListNode(int key){
            this.key = key;
        }
    }

    private final ListNode[] hashSet;

    public MyHashSet() {
        hashSet = new ListNode[1000];
        for(int i = 0; i < hashSet.length; i++){
            hashSet[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        ListNode temp = hashSet[key % hashSet.length];
        while(temp.next != null){
            if(temp.next.key == key)
                return;
            temp = temp.next;
        }
        temp.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode temp = hashSet[key % hashSet.length];
        while(temp.next != null){
            if(temp.next.key == key){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode temp = hashSet[key % hashSet.length];
        while(temp.next != null){
            if(temp.next.key == key)
                return true;
            temp = temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */