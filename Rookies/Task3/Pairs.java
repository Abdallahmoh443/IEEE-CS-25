import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static int pairs(int k, List<Integer> arr) {
        int count = 0;
        Set<Integer> set = new HashSet<>(arr);

        for (int num : arr) {
            if (set.contains(num + k)) {
                count++;
            }
            if (set.contains(num - k)) {
                count++;
            }
            set.remove(num); 
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];

        
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

       
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        
        System.out.println(pairs(k, list));
    }
}
