import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int untreated = 0 ;
        int [] events = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            events[i] = a;
        }
        int sum = 0 ;
        for (int i = 0; i < n; i++) {
            if (sum < 1  && events[i] == -1) {
                untreated ++ ;
            }else {
                sum += events[i];
            }
        }

        System.out.println(untreated);
    }
}