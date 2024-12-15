import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();

        weird(n);
    }

    public static void weird(long n) {
        System.out.print(n + " ");

        if (n == 1) {
            return;
        }

        if (n % 2 == 0) {
            weird(n / 2);
        } else {
            weird(n * 3 + 1);
        }
    }
}
