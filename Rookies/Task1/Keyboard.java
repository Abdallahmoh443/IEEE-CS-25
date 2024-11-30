import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        String string = scan.next();
        System.out.println(handleShift(ch,string));
    }
    public static String handleShift(char ch, String word) {
        String KeyBoard = "qwertyuiopasdfghjkl;zxcvbnm,./";
        char [] chars = KeyBoard.toCharArray();
        StringBuilder sb = new StringBuilder();
        char [] wordchs = word.toCharArray();
        if(ch == 'L' || ch == 'l'){
            for (int i = 0; i < wordchs.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if(chars[j] == wordchs[i]){
                        sb.append(chars[j+1]);
                    }
                }
            }
        }
        if(ch == 'R' || ch == 'r'){
            for (int i = 0; i < wordchs.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if(chars[j] == wordchs[i]){
                        sb.append(chars[j-1]);
                    }
                }
            }
        }
        return sb.toString();
    }
}