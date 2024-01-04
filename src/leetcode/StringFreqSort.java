package leetcode;

import ctci.arraystrings.StringPermutation;

import java.util.*;

public class StringFreqSort {
    public static void main(String[] args) {
        StringFreqSort stringFreqSort = new StringFreqSort();
        stringFreqSort.frequencySort("tree");
    }
    // https://leetcode.com/problems/sort-characters-by-frequency/
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.computeIfPresent(c, (k,v) -> v+1);
            map.computeIfAbsent(c, v -> 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        map.entrySet().forEach(pq::offer);

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char c = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                sb.append(c);
                count --;
            }
        }
        return sb.toString();
    }
}
