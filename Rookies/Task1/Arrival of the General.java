import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
            if (heights[i] <= heights[minIndex]) {
                minIndex = i;
            }
        }


        int moves = maxIndex + (n - 1 - minIndex);


        if (maxIndex > minIndex) {
            moves--;
        }


        System.out.println(moves);
    }
}