import java.util.Scanner;

public class Main {
    public int solution(int n){
        int answer=0;
        boolean isPrime=true;
        for(int i=2; i<=n; i++){
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0)  isPrime=false;
            }
            if(isPrime) answer++;

            isPrime=true;
        }



        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
