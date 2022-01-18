import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr){
        int answer=0, sum=0, s=0;
        for(int e=0; e<n; e++){
            sum+=arr[e];
            if(sum==m)  answer++;
            while(sum>=m){
                sum-=arr[s++];
                if(sum==m)  answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int [n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }
}
