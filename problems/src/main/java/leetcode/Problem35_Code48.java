package leetcode;

public class Problem35_Code48 {
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        //分组
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }

    }

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * <p>
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //左上角
        int tR = 0;
        int tC = 0;

        //右下角
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }

    }
}
