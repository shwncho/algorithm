import java.util.Scanner;

public class Main {
    public int solution(int n){
        int answer=0;
        int[] arr = new int[n];
        int s=0,e=0,sum=0;
        for(int i=0; i<n; i++){
            arr[i]=i+1;
        }
        while(e<n){
            if(sum==n){
                sum-=arr[s];
                answer++;
                s++;
            }
            else if(sum>n){
                sum-=arr[s];
                s++;
            }
            else if(sum<n){
                sum+=arr[e];
                e++;
            }

            if(e==n && sum==n)    answer++;

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
