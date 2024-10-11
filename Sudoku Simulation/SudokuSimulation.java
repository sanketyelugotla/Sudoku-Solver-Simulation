package SPC.Project;

import java.util.Scanner;

import static GFG.Solver.print;
import static GFG.Solver.solveSudoku;
import static SPC.Project.GUI.displayBoard;

public class SudokuSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter level of Sudoku: ");
        int level = sc.nextInt();

        int[][] board1 = {
                {3, 0, 0},
                {0, 3, 0},
                {1, 0, 0}
        };

        int[][] board2 = {
                {2, 0, 4, 0},
                {1, 0, 2, 0},
                {0, 0, 0, 2},
                {0, 2, 0, 4}
        };

        int[][] board3 = {
                {5, 3, 0, 0, 7, 0, 0, 1, 0},
                {6, 0, 0, 1, 9, 5, 0, 4, 0},
                {0, 9, 8, 0, 0, 2, 0, 6, 0},
                {8, 0, 9, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 3, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 0, 0},
                {2, 0, 0, 4, 0, 9, 0, 0, 5},
                {3, 0, 5, 0, 8, 0, 0, 7, 9}
        };

        int[][] board4 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 1, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 2, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 3, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {3, 0, 5, 0, 8, 0, 0, 7, 9}
        };
        boolean answer;
        int[][] board = board1;
        switch (level) {
            case 1: {
                break;
            }
            case 2: {
                board = board2;
                break;
            }
            case 3: {
                board = board3;
                break;
            }
            case 4: {
                board = board4;
            }
        }
        displayBoard(board);
        answer = solveSudoku(board);
        if (answer) print(board);
        else System.out.println("This Sudoku is unsolvable");
    }
}
