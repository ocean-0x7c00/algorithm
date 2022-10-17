package leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            pre.next = listNode;
            pre = listNode;
        }
        return head;
    }
}
