import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }

        System.out.println(MinDiff(arr, n, 0, 0));
    }
    
    public static long MinDiff(long[] weights, int n, long group1Sum, long group2Sum) {
        if (n == 0) {
            return Math.abs(group1Sum - group2Sum);
        }

        long includeInGroup1 = MinDiff(weights, n - 1, group1Sum + weights[n - 1], group2Sum);
        long includeInGroup2 = MinDiff(weights, n - 1, group1Sum, group2Sum + weights[n - 1]);

        return Math.min(includeInGroup1, includeInGroup2);
    }
}
