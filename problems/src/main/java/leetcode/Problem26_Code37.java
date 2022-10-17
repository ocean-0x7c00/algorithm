package leetcode;

/**
 * 解数独
 */
public class Problem26_Code37 {
    public static void main(String[] args) {
        char[][] board = {{'1', '2', '3', '4', '5', '6', '7', '8', '9'}};
        char c1 = board[0][0];
        int c2 = board[0][0] - '0';
        boolean[][] row = new boolean[9][10];
        row[0][c2] = true;
        System.out.println();
    }

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        initMaps(board, row, col, bucket);
        process(board, 0, 0, row, col, bucket);
    }

    public void initMaps(char[][] board, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int bid = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }

    }

    public boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        if (i == 9) {
            return true;
        }

        //如果列数没到8，继续填写这一行，i不变；如果来到了最后一列，转下一行i+1
        int nexti = j != 8 ? i : i + 1;
        int nextj = j != 8 ? j + 1 : 0;

        if (board[i][j] != '.') {
            return process(board, nexti, nextj, row, col, bucket);
        } else {
            int bid = 3 * (i / 3) + (j / 3);
            //1~9的数字，填写位置
            for (int num = 1; num <= 9; num++) {
                if ((!row[i][num]) && (!col[j][num]) && (!bucket[bid][num])) {
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                    board[i][j] = (char) (num + '0');
                    if (process(board, nexti, nextj, row, col, bucket)) {
                        return true;
                    }

                    row[i][num] = false;
                    col[j][num] = false;
                    bucket[bid][num] = false;
                    board[i][j] = '.';

                }
            }
            return false;
        }

    }
}
