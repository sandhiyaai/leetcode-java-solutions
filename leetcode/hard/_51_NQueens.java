import java.io.*;
import java.util.*;

public class Solution {

    public static void print(String board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean safe(int n, String[][] board, int r, int c) {

        // column check
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == "Q") return false;
        }

        // upper-left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Q") return false;
        }

        // upper-right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == "Q") return false;
        }

        return true;
    }

    public static void placequeen(int n, String[][] board, int r) {
        if (r == n) {
            print(board, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (safe(n, board, r, col)) {
                board[r][col] = "Q";
                placequeen(n, board, r + 1);
                board[r][col] = "-";
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.print(0);
            return;
        }

        if (n < 4) {
            System.out.print(-1);
            return;
        }

        String[][] board = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "-";
            }
        }

        placequeen(n, board, 0);
    }
}

