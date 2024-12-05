import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int low = 1, high = n, result = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkV(mid, n, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean checkV(int v, int n, int k) {
        long totalLines = 0;
        long currentV = v;

        while (currentV > 0) {
            totalLines += currentV;
            if (totalLines >= n) return true;
            currentV /= k;
        }

        return totalLines >= n;
    }
}
