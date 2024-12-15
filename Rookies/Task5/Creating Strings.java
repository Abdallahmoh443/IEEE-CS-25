import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.next().toCharArray();
        Arrays.sort(arr);
        Set<String> cases = new TreeSet<>();
        printArray(arr, 0, cases);

        System.out.println(cases.size());

        for (String perm : cases) {
            System.out.println(perm);
        }
    }

    public static void printArray(char[] arr, int start, Set<String> cases) {
        if (start == arr.length) {
            String perm = new String(arr);
            cases.add(perm);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[start]) continue;

            swap(arr, start, i);
            printArray(arr, start + 1, cases);
            swap(arr, start, i);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
