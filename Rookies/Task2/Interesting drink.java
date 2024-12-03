import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n_Shops = scan.nextInt();
        int[] shopsPrices = new int[n_Shops];
        for (int i = 0; i < n_Shops; i++) {
            shopsPrices[i] = scan.nextInt();
        }
        int days = scan.nextInt();
        int[] budget = new int[days];
        for (int i = 0; i < days; i++) {
            budget[i] = scan.nextInt();
        }
        Arrays.sort(shopsPrices);

        for (int i = 0; i < budget.length; i++) {
            System.out.println(bSearch(shopsPrices,budget[i]));
        }
    }
    public static int bSearch(int[] shops, int target) {
        int low = 0;
        int high = shops.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (shops[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

}
