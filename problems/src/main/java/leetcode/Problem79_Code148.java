package leetcode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 使用归并排序，归并的非递归写法
 * <p>
 * 思考题：Morris遍历找到给定的节点的父节点
 */
public class Problem79_Code148 {
    public ListNode sortList(ListNode head) {
        return null;
    }


    public static class ListNode {
        int val;
        leetcode.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, leetcode.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


