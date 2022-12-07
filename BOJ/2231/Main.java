import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,target;

        int cnt=0,start,end;

        n=sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        target=sc.nextInt();
        start=0;
        end=n-1;

        Arrays.sort(arr);
        while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==target){
                cnt++;
                start++;
            }
            else if(sum<target)     start++;
            else if(sum>target)     end--;
        }
        System.out.println(cnt);


    }
}
