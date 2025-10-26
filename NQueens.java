public / N-Queen Problem in Java (Backtracking)
import java.util.Scanner;

public class NQueens {
    static int N;

    // Check if queen can be placed at board[row][col]
    static boolean isSafe(int board[][], int row, int col) {
        // Check left side of row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve N-Queen
    static boolean solveNQueen(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // place queen

                if (solveNQueen(board, col + 1))
                    return true;

                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    // Print board
    static void printBoard(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        int board[][] = new int[N][N];

        if (solveNQueen(board, 0))
            printBoard(board);
        else
            System.out.println("No solution exists");

        sc.close();
    }
} {
    
}
