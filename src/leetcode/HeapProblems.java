package leetcode;

import java.util.*;

public class HeapProblems {

    static class Strength implements Comparable<Strength> {
        int idx; int solders;
        public Strength(int idx, int solders) {
            this.idx = idx;
            this.solders = solders;
        }
        @Override
        public int compareTo(Strength other) {
            int compare = Integer.compare(this.solders, other.solders);
            if (compare != 0)
                return compare;
            else
                return Integer.compare(this.idx, other.idx);
        }
    }
    public static void main(String[] args) {

        HeapProblems heapProblems = new HeapProblems();
        int[][] grid = new int[][] {
                {23,99},
                {83,5},
                {21,76},
                {34,99},
                {63, 23}
        };

        int[][] mat = new int[][] {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        //heapProblems.deleteGreatestInEachRow(grid);
        //heapProblems.deleteGreatestInRow_NoHeap(grid);
        heapProblems.kWeakestRows(mat, 3);
    }

    // https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Strength> solderStrength = new ArrayList<>();
        for (int i = 0; i<mat.length; i++)
            solderStrength.add(getSolderCount(mat[i], i));
        Collections.sort(solderStrength);
        // System.out.println(solderStrength);
        int[] res = new int[k];
        for (int i=0; i<res.length; i++)
            res[i] = solderStrength.get(i).idx;
        return res;
    }

    private Strength getSolderCount(int[] row, int idx) {
        int ctr = 0;
        for (int i : row) {
            if (i == 1)
                ctr++;
        }
        return new Strength(idx, ctr);
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

    // https://leetcode.com/problems/delete-greatest-value-in-each-row/
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
