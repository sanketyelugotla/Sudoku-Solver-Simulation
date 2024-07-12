package GFG;

import static SPC.Project.GUI.*;

public class Solver {
    private static int n;

    public static boolean solveSudoku(int[][] board) {
        n = board.length;
        int speed;
        if (n == 9) speed = 100;
        else speed = 500;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 || board[i][j] == -1) {
                    for (int dig = 1; dig <= n; dig++) {
                        if (isSafe(i, j, dig, board)) {
                            board[i][j] = dig;
                            setUpdated(i, j);
                            print(board);
                            updateBoard(board, i, j);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (solveSudoku(board)) return true;
                            else {
                                board[i][j] = -1;
                                resetUpdated(i, j);
                                updateBoard(board, i, j);
                                print(board);
                                try {
                                    Thread.sleep(speed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int row, int col, int digit, int[][] board) {
        int box = (int)Math.sqrt(n);
        for (int i = 0; i < n; i++) {
            if (board[i][col] == digit) return false;
            if (board[row][i] == digit) return false;
            if (board[box * (row / box) + (i / 3)][box * (col / box) + (i % box)] == digit) return false;
        }
        return true;
    }

    public static void print(int[][] board) {
        int a = (int)Math.sqrt(n);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % a == 0) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % a == 0 && i != 8) System.out.println("-".repeat(3 * n));
        }
    }
}
