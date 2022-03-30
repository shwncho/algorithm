import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1, n2;
        n1=sc.next();
        n2=sc.next();
        StringBuilder sb = new StringBuilder(n1);
        StringBuilder sb2 = new StringBuilder(n2);
        n1=sb.reverse().toString();
        n2=sb2.reverse().toString();
        System.out.println(Integer.parseInt(n1) > Integer.parseInt(n2) ? n1 : n2);

    }
}
