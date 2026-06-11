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
        var clonedByNode = new HashMap<Integer, Node>();

        return dfs(node, clonedByNode);
    }

    private Node dfs(Node node, HashMap<Integer, Node> clonedByMap) {
        if (node == null) return null;

        if (clonedByMap.containsKey(node.val)) {
            return clonedByMap.get(node.val);
        }

        var cloned = new Node(node.val);
        clonedByMap.put(node.val, cloned);

        for (var neighbor : node.neighbors) {
            cloned.neighbors.add(dfs(neighbor, clonedByMap));
        }

        return cloned;
    }

}