/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copyList = new Node(1000);
        Node tempOrig = head, tempNew = copyList;
        HashMap<Node, Node> hMap = new HashMap<>();

        while(tempOrig != null){
            Node newNode = new Node(tempOrig.val);
            tempNew.next = newNode;
            tempNew = newNode;
            hMap.put(tempOrig, tempNew);
            tempOrig = tempOrig.next;
        }
       
        tempNew = copyList.next;
        tempOrig = head;
        while(tempOrig != null){
            tempNew.random = (tempOrig.random == null) ? null : hMap.get(tempOrig.random);
            tempNew = tempNew.next;
            tempOrig = tempOrig.next;
        }
        return copyList.next;
    }
}
