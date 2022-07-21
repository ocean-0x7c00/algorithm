package org.linkedlist;

import org.model.Node;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * <p>
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)
 */
public class Code10_FindFirstIntersectNode {
    public static Node getIntersectNode(Node head1, Node head2) {
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        //都无环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        //都有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);

        }

        //一个有环，一个无环，这种情况肯定不相交
        return null;
    }

    /**
     * 如果一个链表无环，一定能走到null；有环则走不到null
     * <p>
     * <p>
     * <p>
     * 找链表入环的第一个节点
     * 1.使用快慢指针
     * slow=head.next;
     * fast=head.next.next;
     * <p>
     * 2.当slow与fast第一次相遇时，设置fast=head，然后fast和slow都走一步
     * <p>
     * 3.当slow和fast再次相遇时，即为入环的第一个节点
     *
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head) {
        //只要没有环就会命中这个分支，0个节点，1个节点，2节点
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 单链表相交一定是 Y字型结构，相交后一定不会在分叉
     * 最后两个节点如果相等，链表必相交
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int count = 0;

        while (cur1.next != null) {
            count++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            count--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        //找出比较长的链表
        cur1 = (count > 0) ? head1 : head2;
        cur2 = (cur1 == head1) ? head2 : head1;


        count = Math.abs(count);

        while (count > 0) {
            cur1 = cur1.next;
            count--;
        }

        //cur2==cur1表示相交
        while (cur2 != cur1) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    /**
     * 1.两个环不相交
     * 2.有同一个入环节点
     * 3.两个不同的入环节点
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {

        //有同一个入环节点
        if (loop1 == loop2) {
            Node cur1 = head1;
            Node cur2 = head2;

            int count = 0;
            while (cur1 != loop1) {
                count++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                count--;
                cur2 = cur2.next;

            }

            cur1 = (count > 0) ? head1 : head2;
            cur2 = (cur1 == head1) ? head2 : head1;
            count = Math.abs(count);

            while (count > 0) {
                cur1 = cur1.next;
                count--;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;
        }


        Node cur = loop1.next;
        while (cur != loop1) {

            //两个不同的入环节点
            if (cur == loop2) {
                return loop1;
            }
            cur = cur.next;
        }

        return null;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2};
//        Node node = Node.creatNodeToTail(arr);
//        Node cur = node;
//        node.next.next = cur;
//        Node loopNode = getLoopNode(node);
//        System.out.println(loopNode.value);



        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
}
