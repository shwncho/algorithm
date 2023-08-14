import java.util.*;
import java.io.*;


public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=N; i++){
            if(arr[i]==0){
                if(i>=M)    list.add(i);
                for(int j=i; j<=N; j=j+i)    arr[j]=1;
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            sum+=list.get(i);
            min = Math.min(min, list.get(i));
        }
        if(sum==0)    System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}