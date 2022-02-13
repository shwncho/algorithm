import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String solution(int n, int[] arr){
        String answer="U";
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++){
            if(arr[i]==arr[i+1])    answer="D";
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)  arr[i]=sc.nextInt();
        System.out.println(solution(n,arr));
    }
}
