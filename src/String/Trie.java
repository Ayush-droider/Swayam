package String;

public class Trie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("car");
        trie.insert("cat");
        trie.insert("dog");
        System.out.println("Search 'car': " + trie.search("car"));
        System.out.println("Search 'can': " + trie.search("can"));
        System.out.println("Prefix 'ca': " + trie.startsWith("ca"));
        System.out.println("Prefix 'do': " + trie.startsWith("do"));
        System.out.println("Prefix 'de': " + trie.startsWith("de"));
    }
}
