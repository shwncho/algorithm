import java.util.Scanner;

public class Main {
    static long q,r,r1,r2,s,s1,s2,t,t1,t2;
    public static void gcd(long a, long b){
        r1=a; r2=b;
        s1=1; s2=0;
        t1=0; t2=1;

        while(r2>0){
            q=r1/r2;
            r=r1-q*r2;

            r1=r2;
            r2=r;

            s=s1-q*s2;
            s1=s2;
            s2=s;

            t=t1-q*t2;
            t1=t2;
            t2=t;
        }

        //n만큼 더해져도 나머지 값에는 변화가 없으므로 양수 c의 값을 찾기 위해 b(=n)를 계속 더해줌
        while(s1<=0){
            s1+=b;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n =sc.nextLong();
        long a = sc.nextLong();

        gcd(a,n);

        System.out.println(r1==1 ? n-a+" "+s1 : n-a+" "+(-1));




    }
}
