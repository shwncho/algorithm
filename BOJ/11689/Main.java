import java.util.Scanner;

//오일러 파이함수 이용
public class Main {
    public static long solution(long n){
        double answer = n;
        for(long p=2; p*p<=n; p++){
            //p값 소인수 여부 판단
            if(n%p==0){
                //나누어 떨어지지 않을 때까지 나눠준다.
                while(n%p==0){
                    n/=p;
                }
                //오일러 정리
                answer*=(1.0-(1.0/(double)p));
            }
        }
        //p*p<n 일 경우 본인은 제외되므로 본인 체크
        if(n>1){
            answer*=(1.0-(1.0/(double)n));
        }
        return (long)answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(solution(n));


    }
}
