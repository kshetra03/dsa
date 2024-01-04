package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class KthLargestElementPQ {
    public static void main(String[] args) {
        KthLargestElementPQ kthLargestElement = new KthLargestElementPQ(3, new int[] {4,5,8,2});
        System.out.println(kthLargestElement.add(3));
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    int k; int[] nums;
    public KthLargestElementPQ(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        for (int i: nums)
            maxHeap.offer(i);

        for (int i =0; i<k; i++) {
            if (maxHeap.size() != 0) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() == k){
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        } else {
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    // Using single PQ
    /*
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
        }
        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
     */
}
