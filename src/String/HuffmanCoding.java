package String;

import java.util.*;

public class HuffmanCoding {
    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    private static void buildCode(Map<Character, String> map, Node root, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            map.put(root.ch, s);
            return;
        }
        buildCode(map, root.left, s + "0");
        buildCode(map, root.right, s + "1");
    }

    public static Map<Character, String> buildHuffmanTree(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (var e : freq.entrySet()) pq.add(new Node(e.getKey(), e.getValue()));
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node('\0', left.freq + right.freq, left, right));
        }
        Node root = pq.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        buildCode(huffmanCode, root, "");
        codeRoot = root;
        return huffmanCode;
    }

    static Node codeRoot;

    public static String encode(String text, Map<Character, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append(huffmanCode.get(c));
        return sb.toString();
    }

    public static String decode(String encodedText, Node root) {
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for (char bit : encodedText.toCharArray()) {
            node = bit == '0' ? node.left : node.right;
            if (node.left == null && node.right == null) {
                sb.append(node.ch);
                node = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "huffman coding algorithm";
        Map<Character, String> huffmanCode = buildHuffmanTree(text);
        String encoded = encode(text, huffmanCode);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decode(encoded, codeRoot));
    }
}
