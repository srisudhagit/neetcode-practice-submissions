/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> cloneCheckMap = new HashMap<>();
        if(node != null){
            return dfs(node, cloneCheckMap);
        }else{
            return null;
        }
        
    }

    public Node dfs(Node node, Map<Integer, Node> map){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
           
        Node newnode = new Node(node.val);
        map.put(node.val, newnode);
        List<Node> neighList = new ArrayList<>();

        for(Node neigh : node.neighbors){
            Node newChild = dfs(neigh, map);
            neighList.add(newChild);
        }
        newnode.neighbors = neighList;
        return newnode;
    }
}