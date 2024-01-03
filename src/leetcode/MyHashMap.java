package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyHashMap {

    static class KeyValuePair {
        int key;
        int val;
        public KeyValuePair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private static final int DEFAULT_CAPACITY = 1;
    LinkedList<KeyValuePair>[] buckets;
    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    private int getHash(final int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    public void put(int key, int val) {
        int hash = getHash(key);
        LinkedList<KeyValuePair> bucket = buckets[hash];

        // check for collision and presence of key
        for (KeyValuePair kv: bucket) {
            if (kv.key == key) {
                kv.val = val;
                return;
            }
        }
        bucket.add(new KeyValuePair(key, val));
    }

    public int get(int key) {
        int hash = getHash(key);
        LinkedList<KeyValuePair> bucket = buckets[hash];
        for (KeyValuePair kv: bucket) {
            if (kv.key == key)
                return kv.val;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        LinkedList<KeyValuePair> bucket = buckets[hash];

        for (int i = 0; i < bucket.size(); i++) {
            KeyValuePair kv = bucket.get(i);
            if (kv.key == key) {
                bucket.remove();
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        //System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        //System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(3, 3); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.put(4, 4); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]

        //myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        //System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("A", 3);
        System.out.println(map);
    }
}
