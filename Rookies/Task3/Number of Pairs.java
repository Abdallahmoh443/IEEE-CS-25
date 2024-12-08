import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        while (t-- > 0) {
            int n = scan.nextInt();
            int l = scan.nextInt();
            int r = scan.nextInt();
            
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            
            Arrays.sort(arr);
            
            long count = 0;  
            
            for (int i = 0; i < n; i++) {
                int left = i + 1;
                int right = n - 1;
                
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[i] + arr[mid] >= l) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                
                int lowerBound = left;
                
                left = i + 1;
                right = n - 1;
                
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[i] + arr[mid] <= r) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                
                int upperBound = right;
                
                if (lowerBound <= upperBound) {
                    count += (long)(upperBound - lowerBound + 1);  
                }
            }
            
            System.out.println(count);
        }
    }
}
