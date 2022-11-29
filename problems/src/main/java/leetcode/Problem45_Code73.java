package leetcode;

public class Problem45_Code73 {
    public void setZeroes(int[][] matrix) {
        boolean row0Zero = false;
        boolean col0Zero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row0Zero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col0Zero = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }

            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }

            }
        }
        if (row0Zero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }

        }

        if (col0Zero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
