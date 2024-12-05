import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = scan.nextInt();
        }

        long groups = 0;
        int last = 0;

        for (int first = 0; first < n; first++) {
            while (last < n && points[last] - points[first] <= d) {
                last++;
            }
            int k = last - first - 1; 
            if (k >= 2) {
                groups += (long) k * (k - 1) / 2; 
            }
        }

        System.out.println(groups);
    }
}
