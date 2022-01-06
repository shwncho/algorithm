import java.util.Scanner;

public class Main {
    public int solution(int[] arr, int n){
        int answer=1;
        int s=arr[0];
        for(int i=1; i<n; i++){
            if(s<arr[i]){
                answer++;
                s=arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();

        }
        System.out.println(T.solution(arr,n));
    }
}
