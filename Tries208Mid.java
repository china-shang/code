import java.util.Map;
import java.util.HashMap;

class Node {
    public char c;
    public Map<Character, Node> map;
    public boolean isEnd;
    public Node(char _c){
        c = _c;
        map = new HashMap<>();
    }
}
// 使用isEnd来标识为是一个字符串的全部
// search时，判断找到对应的前缀，并且isEnd=true
// 迭代插入,开始在node上准备插入，如果node.map上找到对应的字符，试图继续在map.get(c)上插入
// 如果node.map没有找到c，新建Node,加入map,然后在newNode上继续
// 迭代搜索 在node上查找，node.map没找到return false，否则继续在map.get(c)上继续下面的查找
class Tries208Mid {
    Node node;

    public Tries208Mid() {
        node = new Node('\0');
    }

    public void dfsInsert(Node node, String s, int pos){
        if(pos == s.length()){
            return;
        }
        if(node.map.containsKey(s.charAt(pos))){
            dfsInsert(node.map.get(s.charAt(pos)), s, pos+1);
        }else{
            Node newNode = new Node(s.charAt(pos));
            node.map.put(s.charAt(pos), newNode);
            dfsInsert(newNode, s, pos+1);
        }
    }

    public void insert(String word){
        Node t = node;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(t.map.containsKey(c)){
                t = t.map.get(c);
            } else {
                Node newNode = new Node(c);
                t.map.put(c, newNode);
                t = newNode;
            }
        }
        t.isEnd = true;
    }

    public boolean search(String word) {
        Node t = node;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!t.map.containsKey(c)){
                return false;
            } else {
                t = t.map.get(c);
            }
        }
        return t.isEnd;

    }

    public boolean startsWith(String prefix) {
        Node t = node;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!t.map.containsKey(c)){
                return false;
            } else {
                t = t.map.get(c);
            }
        }
        return true;
    }

    public boolean dfsSearch(Node node, String s, int pos){
        if(pos == s.length()){
            return true;
        }

        if(!node.map.containsKey(s.charAt(pos))){
            return false;
        }
        return dfsSearch(node.map.get(s.charAt(pos)), s, pos+1);
    }
    public static void main(String[] args) {
        Tries208Mid t = new Tries208Mid();
        t.insert("abcde");
        // true
        System.out.println(t.search("abcde"));
        // false
        System.out.println(t.search("abcd"));
        // true
        System.out.println(t.startsWith("abcd"));
        // true
        System.out.println(t.startsWith("ab"));

    }
}
