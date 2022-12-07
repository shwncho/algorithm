import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char s = 'a';

        for(int i=0; i<='z'-'a'; i++){
            System.out.print(input.indexOf(s)+" ");
            s++;
        }
    }
}
