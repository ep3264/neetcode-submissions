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
        if (node == null) return null;
        var map = new HashMap<Integer, Node>();
        buildMap(node, map);

        Node[] nodes = new Node[map.entrySet().size() + 1];
        for (var entry : map.entrySet()) {
            nodes[entry.getKey()] = new Node(entry.getKey());
        }
        for (var curNode : map.values()) {
            var cloned = nodes[curNode.val];
           for (var neighbor : curNode.neighbors) {
               cloned.neighbors.add(nodes[neighbor.val]);
           }
        }

        return nodes[1];
    }

    private void buildMap(Node node, HashMap<Integer, Node> map) {
        map.put(node.val, node);
        for (var neighbor : node.neighbors) {
            if (!map.containsKey(neighbor.val)) {
                map.put(neighbor.val, neighbor);
                buildMap(neighbor, map);
            }
        }


    }
}