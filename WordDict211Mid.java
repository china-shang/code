import java.util.Map;
import java.util.HashMap;

class Node{
    public Map<Character, Node> map;
    public boolean isEnd;
    public Node[] nodes;
    public Node(){
        map = new HashMap<>();
        nodes = new Node[26];
    }
}
// 前缀树, Node不需要存char,对应的槽位有值即代表char
// search使用dfsSearch如果遇到.遍历dfs node下的所有子node
// dfsSearch使用boolean作为return. 使用isEnd作为最后判断
// insert时如果对应槽位不存在，新建添加进去,最后t=t.nodes[idx],for外t.isEnd=true
class WordDict2 {
    Node node;
    public WordDict2(){
        node = new Node();
    }

    public void addWord(String word){
        Node t = node;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(t.nodes[c - 'a'] != null){
                t = t.nodes[c - 'a'];
            } else {
                Node newNode = new Node();
                t.nodes[c - 'a'] = newNode;
                t = newNode;
            }
        }
        t.isEnd = true;
    }
    public boolean search(String word){
        return dfsSearch(node, word, 0);
    }

    private boolean dfsSearch(Node node, String word, int pos){
        if(pos == word.length()){
            return node.isEnd;
        }
        char c = word.charAt(pos);
        if(c == '.'){
            for(Node t: node.nodes){
                if(t != null && dfsSearch(t, word, pos+1)){
                    return true;
                }
            }
            return false;
        } else {
            Node t = node.nodes[c - 'a'];
            return t != null && dfsSearch(t, word, pos+1);
        }
    }
}

// 插入的word中也有.的解法
class WordDict {
    Node node;

    public WordDict() {
        node = new Node();
    }

    public void addWord(String word) {
        Node t = node;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            } else {
                Node newNode = new Node();
                t.map.put(c, newNode);
                t = newNode;
            }
        }
        t.isEnd = true;
    }

    public boolean search(String word) {
        return dfsSearch(node, word, 0) != null;

    }

    public Node dfsSearch(Node node, String word, int pos){
        if(pos == word.length()){
            return node.isEnd ? node : null;
        }
        char c = word.charAt(pos);
        Node res = null;
        if(c == '.'){
            for(Node t: node.map.values()){
                res = dfsSearch(t, word, pos+1);
                if(res != null){
                    return res;
                }
            }
            return null;
        }
        if(node.map.containsKey(c)){
            res = dfsSearch(node.map.get(c), word, pos+1);
            if(res != null){
                return res;
            }
        }
        if(node.map.containsKey('.')){
            res = dfsSearch(node.map.get('.'), word, pos+1);
            if(res != null){
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
