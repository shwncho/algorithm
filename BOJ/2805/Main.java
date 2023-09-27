import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        System.out.println(binarySearch(trees,m));



    }

    public static long binarySearch(int[] trees, int m){
        long left = 0;
        long right = trees[trees.length-1];

        while(left < right){
            long mid = (left+right)/2;

            if(check(mid,trees,m)) left = mid+1;
            else    right = mid;
        }
        //upper bound 방식으로 풀었기 때문에 right - 1
        return right-1;
    }

    public static boolean check(long mid,int[] trees, int m){
        //오버플로우 체크
        long sum = 0;
        for(int i=0; i<trees.length; i++){
            if(trees[i] > mid){
                sum+=trees[i] - mid;
            }
        }
        //나무의 높이의 합은 항상 M보다 크거나 같기 때문에
        return sum >= m;

    }
}