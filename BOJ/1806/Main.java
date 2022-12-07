import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> answer = new ArrayList<>();
        int start=0,end=0;
        int sum=0;

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        sum=arr[0];
        while(end<n){

            if(sum<s){
                end++;
                if(end>=n)  break;
                sum+=arr[end];
            }
            else if(sum>=s){
                answer.add(end-start+1);
                sum-=arr[start];
                start++;
            }
        }

        if(!answer.isEmpty()) System.out.println(Collections.min(answer));
        else System.out.println(0);
    }
}
