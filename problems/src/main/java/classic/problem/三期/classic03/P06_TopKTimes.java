package classic.problem.三期.classic03;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P06_TopKTimes {
    public static void printTopKAndRank(String[] arr, int topK) {
        if (arr == null || arr.length == 0 || topK < 1) {
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        //数组长度可能比topK小
        topK = Math.min(arr.length, topK);

        //构建小根堆
        PriorityQueue<Node> heap = new PriorityQueue<>((node1, node2) -> node1.times - node2.times);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node cur = new Node(entry.getKey(), entry.getValue());
            if (heap.size() < topK) {
                heap.add(cur);
            } else {
                if (heap.peek().times < cur.times) {
                    heap.poll();
                    heap.add(cur);
                }
            }

        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll().str);
        }
    }

    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }
}
