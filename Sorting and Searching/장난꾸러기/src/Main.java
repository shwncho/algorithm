import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] arr2 = new int[n+1];
        arr2=Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        for(int i=1; i<n+1; i++){
            if(arr[i]!=arr2[i]){
                answer.add(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i]=sc.nextInt();
        }
        for(int x:solution(n,arr)){
            System.out.print(x+" ");
        }

    }
}
