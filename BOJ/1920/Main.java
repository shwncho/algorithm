import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static int binarySearch(int key,int n){
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==key)   return 1;

            if(arr[mid]<key)    left=mid+1;
            else right=mid-1;

        }

        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            System.out.println(binarySearch(Integer.parseInt(st.nextToken()),n));
        }
    }
}
