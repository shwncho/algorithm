import java.util.Scanner;

public class Main {
    public static long gcd(long a, long b){
        return b==0 ? a : gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G =sc.nextInt();
        int L = sc.nextInt();

        int divide = L/G;

        long A = 0;
        long B = 0;

        for(int i=1; i<=Math.sqrt(divide); i++){
            if(divide%i==0){
                long a = i;
                long b = divide/i;

                if(gcd(a,b)==1){
                    A=a;
                    B=b;
                }
            }
        }

        System.out.println(A*G+" "+B*G);

    }
}
