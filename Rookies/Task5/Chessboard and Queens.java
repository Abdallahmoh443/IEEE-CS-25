import java.util.*;

public class Main {

    static int count = 0;
    static boolean[] columns = new boolean[8];
    static boolean[] diag1 = new boolean[15];
    static boolean[] diag2 = new boolean[15];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = scanner.next().toCharArray();
        }

        solve(board, 0);
        System.out.println(count);
    }

    public static void solve(char[][] board, int row) {
        if (row == 8) {
            count++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (board[row][col] == '.' && !columns[col] && !diag1[row - col + 7] && !diag2[row + col]) {
                columns[col] = diag1[row - col + 7] = diag2[row + col] = true;
                solve(board, row + 1);
                columns[col] = diag1[row - col + 7] = diag2[row + col] = false;
            }
        }
    }
}
