
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_books = scan.nextInt();
        int avaliable_time = scan.nextInt();
        int [] books_time = new int[num_books];
        for (int i = 0; i < num_books; i++) {
            books_time[i] = scan.nextInt();
        }

        System.out.println(getMaxBooks(books_time, avaliable_time));
    }
    public static int getMaxBooks(int[] books_time , int avaliable_time) {
        int maxStreak = 0 ;
        int last = 0 ;
        int current_streak = 0 ;
        int current_time = 0;
        for (int first = 0; first < books_time.length; first++) {
            while (last < books_time.length && (current_time + books_time[last]) <= avaliable_time) {
                current_time += books_time[last];
                last++;
            }
            current_streak = last - first;

            if(current_streak > maxStreak) {
                maxStreak = current_streak;
            }
            current_time -= books_time[first];
        }
        return maxStreak;
    }
}
