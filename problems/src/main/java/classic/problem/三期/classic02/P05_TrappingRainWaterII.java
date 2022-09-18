package classic.problem.三期.classic02;

import java.util.PriorityQueue;

public class P05_TrappingRainWaterII {

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }

        int N = heightMap.length;
        int M = heightMap[0].length;
        boolean[][] exitMap = new boolean[N][M];
        PriorityQueue<Node> heap = new PriorityQueue<>((node1, node2) -> node1.value - node2.value);


        //先放第0行
        for (int col = 0; col < M - 1; col++) {
            heap.add(new Node(heightMap[0][col], 0, col));
            exitMap[0][col] = true;
        }
        for (int row = 0; row < N - 1; row++) {
            heap.add(new Node(heightMap[row][M - 1], row, M - 1));
            exitMap[row][M - 1] = true;
        }
        for (int col = M - 1; col > 0; col--) {
            heap.add(new Node(heightMap[N - 1][col], N - 1, col));
            exitMap[N - 1][col] = true;
        }

        for (int row = N - 1; row > 0; row--) {
            heap.add(new Node(heightMap[row][0], row, 0));
            exitMap[row][0] = true;
        }


        int water = 0;
        int max = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            max = Math.max(max, cur.value);

            int r = cur.row;
            int c = cur.col;

            //左
            if (c - 1 >= 0 && !exitMap[r][c - 1]) {
                //计算放入堆中的格子[r][c-1]上面能存多少水
                water += Math.max(max - heightMap[r][c - 1], 0);
                heap.add(new Node(heightMap[r][c - 1], r, c - 1));
                exitMap[r][c - 1] = true;
            }
            //右
            if (c + 1 < M && !exitMap[r][c + 1]) {
                water += Math.max(max - heightMap[r][c + 1], 0);

                heap.add(new Node(heightMap[r][c + 1], r, c + 1));
                exitMap[r][c + 1] = true;
            }

            //上
            if (r - 1 >= 0 && !exitMap[r - 1][c]) {
                water += Math.max(max - heightMap[r - 1][c], 0);

                heap.add(new Node(heightMap[r - 1][c], r - 1, c));
                exitMap[r - 1][c] = true;
            }

            //下
            if (r + 1 < N && !exitMap[r + 1][c]) {
                water += Math.max(max - heightMap[r + 1][c], 0);

                heap.add(new Node(heightMap[r + 1][c], r + 1, c));
                exitMap[r + 1][c] = true;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        int water = trapRainWater(arr);
        System.out.println(water);
    }

    public static class Node {
        int value;
        int row;
        int col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}





