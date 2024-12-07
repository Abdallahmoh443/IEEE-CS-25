import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] choc = new int[n];
        
        for (int i = 0; i < n; i++) {
            choc[i] = scan.nextInt();
        }
        
        int alice = 0;
        int bob = n - 1;
        
        int alice_eat = 0;
        int bob_eat = 0;
        
        int alice_count = 0;
        int bob_count = 0;
        
        while (alice <= bob) {
            if (alice_eat <= bob_eat) {
                alice_eat += choc[alice];
                alice_count++;
                alice++;
            } else {
                bob_eat += choc[bob];
                bob_count++;
                bob--;
            }
        }
        
        System.out.println(alice_count + " " + bob_count);
    }
}
