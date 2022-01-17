import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr){
        int answer=0;
        int start=0,end=0,sum=0;
        while(end<n){
            if(sum==m){
                sum-=arr[start];
                answer++;
                start++;
            }
            else if(sum>m){
                sum-=arr[start];
                start++;
            }
            else if(sum<m){
                sum+=arr[end];
                end++;
            }

            if(end==n && sum==m)    answer++;

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
