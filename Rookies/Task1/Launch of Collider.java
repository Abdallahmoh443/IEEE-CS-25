import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String directions = scanner.next();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
        }

        int minCollisionTime = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (directions.charAt(i) == 'R' && directions.charAt(i + 1) == 'L') {
                int collisionTime = (positions[i + 1] - positions[i]) / 2;
                if (collisionTime < minCollisionTime) {
                    minCollisionTime = collisionTime;
                }
            }
        }

        if (minCollisionTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCollisionTime);
        }
    }
}
