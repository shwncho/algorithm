import java.util.Scanner;

public class Main {
    public void solution(int[] arr, int n){
        System.out.print(arr[0]+" ");
        for(int i=1; i<n; i++){
            if(arr[i-1]<arr[i]) System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        T.solution(arr,n);

    }
}
