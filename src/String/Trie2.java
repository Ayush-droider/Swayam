package String;

public class Trie2 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        int wordCount;
    }

    private final TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
            node.wordCount++;
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

    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int index) {
        if (node == null) return false;
        if (index == word.length()) {
            if (!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            return isEmpty(node);
        }
        int idx = word.charAt(index) - 'a';
        if (deleteHelper(node.children[idx], word, index + 1)) {
            node.children[idx] = null;
            return !node.isEndOfWord && isEmpty(node);
        }
        node.wordCount--;
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null) return false;
        return true;
    }

    public int countWords() {
        return countWordsHelper(root);
    }

    private int countWordsHelper(TrieNode node) {
        if (node == null) return 0;
        int count = node.isEndOfWord ? 1 : 0;
        for (TrieNode child : node.children)
            count += countWordsHelper(child);
        return count;
    }

    public boolean wordBreak(String s) {
        Boolean[] dp = new Boolean[s.length()];
        return wordBreakHelper(s, 0, dp);
    }

    private boolean wordBreakHelper(String s, int start, Boolean[] dp) {
        if (start == s.length()) return true;
        if (dp[start] != null) return dp[start];
        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) break;
            node = node.children[idx];
            if (node.isEndOfWord && wordBreakHelper(s, i + 1, dp))
                return dp[start] = true;
        }
        return dp[start] = false;
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("car");
        trie.insert("cat");
        trie.insert("dog");
        trie.insert("cart");
        trie.insert("do");
        System.out.println(trie.search("car"));
        System.out.println(trie.startsWith("ca"));
        System.out.println(trie.countWords());
        trie.delete("cart");
        System.out.println(trie.search("cart"));
        System.out.println(trie.countWords());
        String s = "dogcat";
        System.out.println(trie.wordBreak(s));
    }
}
