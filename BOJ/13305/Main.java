import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] distances = new int[n-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());


        int[] choice = new int[n-1];
        int minCost = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            costs[i] = Integer.parseInt(st.nextToken());
            if(costs[i] < minCost){
                choice[i] = costs[i];
                minCost = costs[i];
            }
            else choice[i] = minCost;
        }

        System.out.println(solution(n, choice, distances));

    }

    public static long solution(int n, int[] choice, int[] distances){
        long sum = 0;
        for(int i=0; i<n-1; i++){
            sum += (long)choice[i] * (long)distances[i];
        }
        return sum;
    }
}