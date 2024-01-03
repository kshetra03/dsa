package leetcode;

// https://leetcode.com/problems/kth-largest-element-in-an-array/ 
public class KthLargestElement {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5,6};
        KthLargestElement kthLargestElement = new KthLargestElement();
        kthLargestElement.swap(a, 1, 2);
        System.out.println(a[1]);
    }

    public int findKthLargest(int[] nums, int k) {
        int actualK = nums.length - k;

        return quickSelect(nums, 0, nums.length-1, actualK);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pLoc = partition(nums, low, high);

        if (pLoc == k) return nums[pLoc];
        if (pLoc > k) {
            return quickSelect(nums, low, pLoc-1, k);
        }
        return quickSelect(nums, pLoc+1, high, k);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i,j;
        i=low;
        j=low;
        while(j<high){
            if(nums[j]<=pivot){
                if(i!=j){
                    swap(nums, i, j);
                }
                i++;
            }
            j++;
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
