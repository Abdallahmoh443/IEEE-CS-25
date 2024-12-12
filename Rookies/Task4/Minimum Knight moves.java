import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();


        for (int t = 0; t < T; t++) {
            String[] input = scanner.nextLine().split(" ");
            String start = input[0];
            String destination = input[1];
            int startX = start.charAt(0) - 'a';
            int startY = start.charAt(1) - '1';
            int destX = destination.charAt(0) - 'a';
            int destY = destination.charAt(1) - '1';

            System.out.println(bfs(startX, startY, destX, destY));
        }
    }

    private static int bfs(int startX, int startY, int destX, int destY) {
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], moves = current[2];

            if (x == destX && y == destY){
                return moves;
            }

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY, moves + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}
