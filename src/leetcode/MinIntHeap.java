package leetcode;

import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    int[] items = new int[capacity];
    private int size = 0;

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int childIndex) {
        return (childIndex - 1)/2;
    }
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    private int parent(int index) {
        return items[getParentIndex(index)];
    }
    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size --;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    public void heapifyDown() {
        int idx = 0;
        int smallerIdx;
        // find the smaller element out of the child nodes
        while(hasLeftChild(idx)) {
            if(leftChild(idx) > rightChild(idx))
                smallerIdx = getRightChildIndex(idx);
            else
                smallerIdx = getLeftChildIndex(idx);
            if (items[smallerIdx] > items[idx]) {
                break;
            } else {
                swap(idx, smallerIdx);
            }
            idx = smallerIdx;
        }

    }

    public void heapifyUp() {
        int idx = size - 1;
        while(hasParent(idx) && items[idx] < parent(idx)) {
            swap(idx, getParentIndex(idx));
            idx = getParentIndex(idx);
        }
    }

    public void printHeap() {
        for (int i =0; i<size; i++)
            System.out.print(items[i] + "--");
        System.out.println();
    }
    public static void main(String[] args) {
        MinIntHeap minIntHeap = new MinIntHeap();
        minIntHeap.add(43);
        minIntHeap.add(42);
        minIntHeap.add(21);
        minIntHeap.add(32);
        minIntHeap.add(56);
        minIntHeap.add(9);
        minIntHeap.printHeap();
        System.out.println("min element --> " + minIntHeap.peek());
        System.out.println(minIntHeap.poll());
        minIntHeap.printHeap();
    }
}
