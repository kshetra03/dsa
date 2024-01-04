package leetcode;

import java.util.*;

public class MaxSubsequence {
    static class MaxVal implements Comparable<MaxVal> {
        int num; int idx;
        public MaxVal(int num, int idx) {
            this.num = num; this.idx = idx;
        }

        @Override
        public int compareTo(MaxVal other) {
            return Integer.compare(this.num, other.num);
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<MaxVal> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<nums.length; i++) {
            pq.offer(new MaxVal(nums[i], i));
        }

        MaxVal[] res = new MaxVal[k];
        int i = 0;
        int size = k;
        while (size>0) {
            res[i] = pq.poll();
            size--; i++;
        }
        Arrays.sort(res, new Comparator<MaxVal>() {
            @Override
            public int compare(MaxVal o1, MaxVal o2) {
                return o1.idx - o2.idx;
            }
        });
        int[] ret =  new int[k];
        for (i=0; i<res.length; i++) {
            ret[i] = nums[res[i].idx];
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxSubsequence maxSubsequence = new MaxSubsequence();
        maxSubsequence.maxSubsequence(new int[]{3,4,3,3}, 2);
    }

}
