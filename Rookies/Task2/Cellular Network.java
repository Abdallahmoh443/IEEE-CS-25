import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_cities = scan.nextInt();
        int num_towers = scan.nextInt();
        int []cities =  new int[num_cities];
        int []towers = new int[num_towers];
        for (int i = 0; i < num_cities; i++) {
            cities[i] = scan.nextInt();
        }
        for (int i = 0; i < num_towers; i++) {
            towers[i] = scan.nextInt();
        }
        System.out.println(getR(cities, towers));
    }
    public static int getR(int []cities , int[] towers) {
        int max = 0 ;
        int r = 0 ;
        for (int i = 0; i < cities.length; i++) {
            r = Math.abs(cities[i] - binarySearchNearest(towers, cities[i]));
            if(r > max){
                max = r;
            }
        }
        return max;
    }
    public static int binarySearchNearest(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int nearest = arr[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;


            if (arr[mid] == target) {
                return arr[mid];
            }


            if (Math.abs(arr[mid] - target) < Math.abs(nearest - target)) {
                nearest = arr[mid];
            }


            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nearest;
    }
}
