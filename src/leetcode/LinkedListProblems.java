package leetcode;

import java.util.List;
import java.util.Stack;

public class LinkedListProblems {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListProblems linkedListProblems = new LinkedListProblems();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(3, new ListNode(4))));

        ListNode l13 = new ListNode(2, new ListNode(1, new ListNode(3)));
        // linkedListProblems.printNodes(linkedListProblems.mergeTwoLists(l1, l2));
        // linkedListProblems.printNodes(linkedListProblems.removeFromList(l2, 0));
        // linkedListProblems.printNodes(linkedListProblems.removeDupFromSortedList(l2));
        // System.out.println((linkedListProblems.hasCycle(l1)));
        // linkedListProblems.printNodes(linkedListProblems.removeElements(l13, 2));
        // linkedListProblems.printNodes(linkedListProblems.reverseList(l13));
        System.out.println(linkedListProblems.isPalindrome(new ListNode(1, new ListNode(2))));
        System.out.println(linkedListProblems.isPalindrome_withoutUsingStack(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(1))))));
    }

    public boolean isPalindrome_withoutUsingStack(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // find the mid
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow points to mid

        // reverse the 2nd half of the linked-list
        ListNode curr = slow;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // check if the reversed half are equal
        while (prev != null) {
            if (prev.val != head.val)
                return false;

            prev = prev.next;
            head = head.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode curr = head;
        Stack<Integer> s = new Stack<Integer>();
        while(curr != null) {
            s.push(curr.val);
            curr = curr.next;
        }

        while(head != null) {
            if (s.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            // update
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        while(curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else
                curr = curr.next;
        }
        return dummy.next;
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public ListNode removeDupFromSortedList(final ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else
                curr = curr.next;
        }
        return head;
    }
    public ListNode removeFromList(final ListNode root, int target) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        dummy.next = root;

        while (curr.next != null && curr.next.val != target)
            curr = curr.next;

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res = new ListNode(-1);
        ListNode curr = res;

        // create list until any list is empty
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        // when one of the lists is not processed fully
        if (list1 != null)
            curr.next = list1;
        if (list2 != null)
            curr.next = list2;

        return res.next;
    }
    public void printNodes(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "-->");
            root = root.next;
        }
    }

}


