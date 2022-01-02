import java.util.*;
public class Main {
    public void solution(String[] str, int N){

        for(int i=0; i<N; i++) {
            StringBuilder answer = new StringBuilder(str[i]);
            System.out.println(answer.reverse());

        }
    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str= new String[N];
        for(int i=0; i<N; i++) {
             str[i]=sc.next();
        }

        T.solution(str,N);
    }
}
