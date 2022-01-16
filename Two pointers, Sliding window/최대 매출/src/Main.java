import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer=0,max=Integer.MIN_VALUE;
        int s=0,e=0,sum=0;
        while(e<n){
            if(e-s==k){
                max=Math.max(max,sum);
                sum-=arr[s];
                s++;
            }

            sum+=arr[e];
            e++;
        }

        answer=max;
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
