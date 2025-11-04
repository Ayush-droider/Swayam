package Trees;

import java.util.*;

public class MyHashMap {

    static class Pair {
        int key, value;
        Pair(int k, int v) {
            key = k;
            value = v;
        }
    }

    private LinkedList<Pair>[] map;
    private int size;

    public MyHashMap() {
        size = 100;
        map = new LinkedList[size];
        for (int i = 0; i < size; i++)
            map[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Pair p : map[index]) {
            if (p.key == key) {
                p.value = value;
                return;
            }
        }
        map[index].add(new Pair(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        for (Pair p : map[index]) {
            if (p.key == key)
                return p.value;
        }
        return -1;
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        for (Pair p : map[index]) {
            if (p.key == key)
                return true;
        }
        return false;
    }

    public Set<Integer> keySet() {
        Set<Integer> keys = new HashSet<>();
        for (LinkedList<Pair> list : map)
            for (Pair p : list)
                keys.add(p.key);
        return keys;
    }

    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        m.put(1, 10);
        m.put(2, 20);
        m.put(3, 30);
        m.put(2, 50);
        System.out.println("Get(2): " + m.get(2));
        System.out.println("ContainsKey(3): " + m.containsKey(3));
        System.out.println("All Keys: " + m.keySet());
        System.out.println("Get(5): " + m.get(5));
    }
}
