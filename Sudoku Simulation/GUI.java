package SPC.Project;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    private static int n;
    private static JButton[][] buttons;
    private static boolean[][] updatedCells;

    public static void printBoard(int[][] board) {
        n = board.length;
        buttons = new JButton[n][n]; // Initialize buttons array with correct dimensions
        updatedCells = new boolean[n][n]; // Initialize the array to track updated cells

        // Create the frame
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600); // Set the frame size

        // Create a panel with a BorderLayout to center the Sudoku grid
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Create a bordered panel to hold the Sudoku grid
        JPanel borderedPanel = new JPanel(new GridLayout(n, n));
        borderedPanel.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, new Color(122, 56, 56))); // Wooden border color
        mainPanel.add(borderedPanel, BorderLayout.CENTER);


        int box = (int)Math.sqrt(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                borderedPanel.add(buttons[i][j]);

                // Set custom borders for each button
                Border border = BorderFactory.createMatteBorder(
                        i % box == 0 ? box : 1,
                        j % box == 0 ? box : 1,
                        1,
                        j == n - 1 ? box : 0,
                        Color.BLACK
                );
                buttons[i][j].setBorder(border);
            }
        }

        // Make the frame visible
        frame.setVisible(true);

        // Initial update of the board
        updateBoard(board, -1, -1);
    }

    public static void updateBoard(int[][] board, int updatedRow, int updatedCol) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.WHITE);
                } else if (board[i][j] == -1) {
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.RED);
                } else {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                    if (updatedCells[i][j]) {
                        buttons[i][j].setBackground(Color.GREEN);
                    } else {
                        buttons[i][j].setBackground(new Color(74, 117, 134));
                    }
                }
            }
        }
    }

    public static void setUpdated(int row, int col) {
        updatedCells[row][col] = true;
    }

    public static void resetUpdated(int row, int col) {
        updatedCells[row][col] = false;
    }
}
