import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        char[][] grid = new char[n][m];
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }

        String result = bfs(grid, n, m, startX, startY, endX, endY);
        System.out.println(result);
    }

    private static String bfs(char[][] grid, int n, int m, int startX, int startY, int endX, int endY) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[] directions = {'R', 'L', 'D', 'U'};

        boolean[][] visited = new boolean[n][m];
        int[][] parentX = new int[n][m];
        int[][] parentY = new int[n][m];
        char[][] move = new char[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return constructPath(parentX, parentY, move, startX, startY, endX, endY);
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] != '#' && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    parentX[newX][newY] = x;
                    parentY[newX][newY] = y;
                    move[newX][newY] = directions[i];
                }
            }
        }

        return "NO";
    }

    private static String constructPath(int[][] parentX, int[][] parentY, char[][] move, int startX, int startY, int endX, int endY) {
        StringBuilder path = new StringBuilder();
        int x = endX;
        int y = endY;

        while (x != startX || y != startY) {
            path.append(move[x][y]);
            int prevX = parentX[x][y];
            int prevY = parentY[x][y];
            x = prevX;
            y = prevY;
        }

        path.reverse();
        return "YES\n" + path.length() + "\n" + path.toString();
    }
}
