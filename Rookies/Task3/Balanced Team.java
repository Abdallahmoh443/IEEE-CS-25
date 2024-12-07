import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = scan.nextInt();
        }
        Arrays.sort(students);
        int count = 0;
        int last = 0;
        int max = 0;
        for (int first = 0; first < n; first++) {
            while(last < n && (students[last] - students[first] ) <= 5) {

                last++;
            }
            count = last - first ;
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
    }
}
