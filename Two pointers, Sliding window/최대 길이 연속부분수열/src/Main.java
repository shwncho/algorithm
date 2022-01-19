import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer=0, s=0,cnt=0;
        for(int e=0; e<n; e++){
            if(arr[e]==0)   cnt++;
            while(cnt>k){
                if(arr[s]==0)   cnt--;
                s++;
            }
            answer=Math.max(answer,e-s+1);
        }


        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(T.solution(n,k,arr));
    }
}
