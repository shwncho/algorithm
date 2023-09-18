import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)  arr1[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)  arr2[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr2);

            int cnt = 0;
            for(int i=0; i<n; i++){
                cnt += binarySearch(0, arr2.length-1, arr1[i],arr2);
            }
            sb.append(cnt).append("\n");

        }

        System.out.println(sb);
    }

    public static int binarySearch(int left, int right, int key, int[] arr2){
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(key > arr2[mid]) left = mid +1;
            else right = mid-1;
        }
        return left;
    }
}