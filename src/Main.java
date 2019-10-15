import java.util.HashMap;

public class Main {
    static class Trie{
        boolean isLeaf;
        HashMap<Character, Trie> map = new HashMap<>();
    }
    public static void insert(String s, Trie head){
        if(s == null || s.length() == 0){
            return ;
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(head.map.containsKey(chars[i])){
                head = head.map.get(chars[i]);
            }else{
                head.map.put(chars[i], new Trie());
                head = head.map.get(chars[i]);
            }
        }
        head.isLeaf = true;
    }
    public static void get(String s, Trie head){
        if(s == null || s.length() == 0){
            return ;
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!head.map.containsKey(chars[i])){
                return ;
            }
            head = head.map.get(chars[i]);
        }
        print(s, head);
    }
    public static void print(String s, Trie head){
        if(head.isLeaf){
            System.out.println(s);
        }
        for(char c : head.map.keySet()){
            print(s + String.valueOf(c), head.map.get(c));
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        insert("aa", trie);
        insert("ab", trie);
        insert("a", trie);
        insert("aaaaab", trie);
        get("a", trie);
    }
}
