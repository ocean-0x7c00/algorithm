package leetcode;

import leetcode.model.ListNode;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 */
public class Problem19_Code23 {
    /**
     * 小根堆
     * 先把数组中的节点放入小根堆
     * 然后取出堆顶元素，将该元素的下一个节点放入小根堆，重复这一步骤，直到堆中元素为空
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> heap = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode node : lists) {
            if (node!=null){
                heap.add(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = null;
        ListNode pre = null;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            if (pre == null) {
                pre = cur;
                head = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }


            if (cur.next != null) {
                heap.add(cur.next);
            }

        }
        return head;
    }


}
