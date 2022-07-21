package org.linkedlist;

import org.model.Node;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 1）把链表放入数组里，在数组上做partition（笔试用）
 * 2）分成小、中、大三部分，再把各个部分之间串起来（面试用）
 */
public class Code08_LinkedListPartition {
    public static Node partition(Node head, int value) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail

        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < value) {

                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }

            } else if (head.value == value) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }


            } else {

                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }


            }

            head = next;
        }


        //合并链表
        if (sT != null) {
            sT.next = eH;
            eT = (eT == null) ? sT : eT;
        }

        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);

    }


    public static void main(String[] args) {
        //1 2 2 3 3 3 4 4 5 7 8 9
        int[] arr = {9, 1, 2, 3, 4, 5, 7, 8, 4, 3, 2, 3};
        Node node = Node.creatNodeToTail(arr);
        Node partition = partition(node, 2);
        Node.printNode(partition);
        System.out.println();
    }
}
