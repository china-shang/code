import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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

class CloneGraphic133Mid {
    private static Map<Node, Node> map = new HashMap<>();
    // 如果当前节点已克隆,返回其克隆节点,
    // 否则克隆当前节点,放入map,然后遍历克隆相连节点,作为相连节点
    public static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node nNode : node.neighbors){
            newNode.neighbors.add(cloneGraph(nNode));
        }
        return newNode;
    }
    public static void main(String[] args) {

    }
}

