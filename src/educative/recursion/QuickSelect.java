package educative.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSelect {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(10, 5, 2, 0, 7, 6, 4);
        int k = 3;
//        int n = A.size();
  //      System.out.println(quickSelect(A, k-1));
    //    System.out.println("kth Largest" + quickSelect(A, n - k));
      //  quickSort(A);
        //System.out.println("Sorted -- " + A);
        QuickSelect select = new QuickSelect();
        int[] nums = new int[] {10, 5, 2, 0, 7, 6, 4};

        System.out.println(select.findKthLargest(nums, nums.length - k));
    }

    // Returns the kth Smallest element from the list
    public static int quickSelect(List<Integer> list, int k) {
        int pivot = quickPartition(list, list.size() - 1);
        if (pivot > k) {
            List<Integer> leftSubArray = list.subList(0, pivot);
            return quickSelect(leftSubArray, k);
        } else if (pivot < k) {
            List<Integer> rightSubArray = list.subList(pivot + 1, list.size()-1);
            return quickSelect(rightSubArray, k - pivot -1 );
        } else {
            return list.get(pivot);
        }
    }
    public static int quickPartition(List<Integer> a, int p) {
        int pivot = a.get(p);
        Collections.swap(a, p, a.size() - 1);
        int i = 0;
        for (int j = 0; j < a.size() - 1; j++) {
            if (pivot > a.get(j)) {
                Collections.swap(a, i, j);
                i ++;
            }
        }
        Collections.swap(a, i, a.size()-1);
        return i;
    }

    public static void quickSort(List<Integer> list) {
        quickSort(list, 0, list.size()-1);
    }

    private static void quickSort(List<Integer> list, int l, int h) {
        if (l < h) {
            int p = quickPartition(list, h);
            quickSort(list, 0, p-1);
            quickSort(list, p, h);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        return quickSelect(nums, 0, nums.length-1, k);
    }

    private int quickSelect(int[] nums, int l, int h, int k) {
        int pLoc = partition(nums, nums.length -1);
        if (l < h) {
            if (k > pLoc)
                return quickSelect(nums, pLoc+1, h, k - pLoc -1);
            else if (k < pLoc)
                return quickSelect(nums, l, pLoc , k);
            else
                return nums[pLoc];
        }
        return nums[l];
    }

    private int partition(int[] nums, int key) {
        int pivot = nums[key];
        int i = 0;
        for (int j = 0; j < nums.length -1; j++) {
            if (pivot > nums[j]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, nums.length -1, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
