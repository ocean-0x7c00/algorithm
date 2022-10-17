package leetcode;

import leetcode.model.ListNode;

public class Problem15_Code19 {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2});
        ListNode listNode = new Problem15_Code19().removeNthFromEnd(head, 2);
        System.out.println();

    }

    /**
     * 快慢指针，删除倒数第K个节点
     * 先数出K+1个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            n--;
            if (n == -1) {
                pre = head;
            }
            if (n < -1) {
                pre = pre.next;
            }
            cur = cur.next;
        }
        if (n > 0) {
            return head;
        }
        //倒数第N个正好是头检点
        if (pre == null) {
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
