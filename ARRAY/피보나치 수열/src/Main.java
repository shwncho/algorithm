import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public int[] solution(int n){
        int [] answer = new int[n];
        for(int i=0; i<n; i++){
            if(i<2) answer[i]=1;
            else{
                answer[i]=answer[i-1]+answer[i-2];
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int x:T.solution(n)){
            System.out.print(x+" ");
        }
    }
}
