import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum=0;
        for(int i=0; i<9; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }

        solution(arr,sum);

        Arrays.sort(arr);
        for(int i=2; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    public static void solution(int[] arr, int sum){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(sum-(arr[i]+arr[j])==100){
                    arr[i]=-1;
                    arr[j]=-1;
                    return;
                }
            }
        }
    }
}


