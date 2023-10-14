import java.util.*;
import java.io.*;

public class Main{
    static int n,m;
    static int[] arr1,arr2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr1 = new int[n];
            for(int i=0; i<n; i++)    arr1[i] = Integer.parseInt(st.nextToken());

            m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr2 = new int[m];
            for(int i=0; i<m; i++)    arr2[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr1);

            for(int i=0; i<m; i++){
                if(binarySearch(0,arr1.length-1,arr2[i]))    sb.append("1").append("\n");
                else    sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int left, int right, int key){
        int mid;
        while(left<=right){
            mid = (left + right)/2;

            if(key>arr1[mid])    left = mid + 1;
            else if(key<arr1[mid])    right = mid - 1;
            else    return true;
        }
        return false;
    }
}