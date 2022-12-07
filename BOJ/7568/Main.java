import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt=1;
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] height = new int[n];
        int rank;

        for(int i=0; i<n; i++){
           weight[i]=sc.nextInt();
           height[i]=sc.nextInt();
        }

        for(int i=0; i<n; i++){
            rank=1;
            for(int j=0; j<n; j++){
                if(i==j)    continue;
                if(weight[j]>weight[i] && height[j]>height[i]){
                    rank++;
                }

            }
            System.out.print(rank+" ");
        }

    }
}
