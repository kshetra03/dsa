package leetcode;

import java.awt.event.ComponentAdapter;
import java.util.*;
import java.util.stream.Stream;

public class HeapProblems {
    public static void main(String[] args) {

        HeapProblems heapProblems = new HeapProblems();
        int[][] grid = new int[][] {
                {23,99},
                {83,5},
                {21,76},
                {34,99},
                {63, 23}
        };
        heapProblems.deleteGreatestInEachRow(grid);
        heapProblems.deleteGreatestInRow_NoHeap(grid);
    }

    // https://leetcode.com/problems/delete-greatest-value-in-each-row/
    public int deleteGreatestInEachRow(int[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<Integer>[] heaps = new PriorityQueue[rows];

        // init the heaps
        for (int i=0; i < rows; i++) {
            heaps[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                heaps[i].offer(grid[i][j]);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(!heaps[rows-1].isEmpty()) {
            int k = 0;
            while(k < rows) {
                pq.offer(heaps[k].poll());
                k++;
            }
            res += pq.poll();
            pq.clear();
        }
        System.out.println(res);
        return res;
    }

    public int deleteGreatestInRow_NoHeap(int[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // sort the matrix by rows
        for (int[] arr: grid)
            Arrays.sort(arr);

        // traverse the matrix column wise and add the max of in the column to the result
        for (int j = cols-1; j >= 0; j--) {
            int max = Integer.MIN_VALUE;
            for (int i=0; i<rows; i++) {
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        System.out.println(res);
        return res;
    }

    private void sortByColumn(int[][] arr, int col) {
        Arrays.sort(arr, (int[] o1, int[] o2) -> {
            if (o1[col]>o2[col])
                return 1;
            else
                return -1;
        });
    }
}
