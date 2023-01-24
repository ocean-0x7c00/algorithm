package leetcode;

public class Problem77_Code141 {
    public boolean hasCycle(ListNode head) {
        return getFirstLoopNode(head) != null;
    }

    public ListNode getFirstLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (slow != fast) {
            if (fast != null || fast.next.next != null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}