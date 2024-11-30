import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> Alllucky = new ArrayList<Integer>();
        for (int i = 1; i < 1000; i++) {
            if(islucky(i))
                Alllucky.add(i);
        }
        boolean notalmostLucky = true;
        for (int i = 0; i < Alllucky.size(); i++) {
            if(n % Alllucky.get(i) == 0){
                System.out.println("YES");
                notalmostLucky = false;
                break;
            }
        }
        if (notalmostLucky) {
            System.out.println("NO");
        }

    }

    public static boolean islucky(int n){
        char [] digits = String.valueOf(n).toCharArray();
        boolean lucky = true;
        for(int i = 0; i < digits.length; i++){
            if(Character.getNumericValue(digits[i]) != 4 && Character.getNumericValue(digits[i]) != 7){
                lucky = false;
                break;
            }
        }
        return lucky;
    }
}