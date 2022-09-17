package classic.problem.三期.classic01;

public class P04_MaxOneBorderSize {
    public static void setBorderMap(int[][] m, int[][] right, int[][] down) {
        int colSize = m[0].length;
        int rowSize = m.length;
        //填写right的最后一列
        for (int row = 0; row < rowSize; row++) {
            right[row][colSize - 1] = m[row][rowSize];
        }
        //填写right[0...colSize-2]
        for (int col = colSize - 2; col >= 0; col--) {
            for (int row = 0; row < rowSize; row++) {
                if (m[row][col] == 1) {
                    right[row][col] = m[row][col] + right[row][col + 1];
                }
            }

        }

        //填写down最后一行
        for (int col = 0; col < colSize; col++) {
            down[rowSize - 1][col] = m[rowSize - 1][col];
        }

        for (int row = rowSize - 2; row >= 0; row--) {
            for (int col = 0; col < colSize; col++) {
                if (m[row][col] == 1) {
                    down[row][col] = m[row][col] + down[row + 1][col];
                }
            }
        }

    }

    public static int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m, right, down);

        //枚举边长
        for (int size = Math.max(m.length, m[0].length); size != 0; size--) {
            if (hasSizeOfBorder(size, right, down)) {
                return size;
            }
        }
        return 0;
    }


    public static boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for (int row = 0; row < right.length - size + 1; row++) {
            for (int col = 0; col < right[0].length - size + 1; col++) {
                if (right[row][col] >= size && down[row][col] >= size && right[row + size - 1][col] >= size && down[row][col + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 0, 1}, {0, 0, 1, 0}, {1, 1, 0, 1},};

        getMaxSize(arr);

    }
}
