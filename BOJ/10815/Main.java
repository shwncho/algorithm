import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        //상근이가 갖고 있는 카드들
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m =Integer.parseInt(br.readLine());
        int[] target = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int x : target){
            sb.append(search(arr, x, 0, arr.length - 1)).append(" ");
        }
        System.out.println(sb);

    }

    public static int search(int[] arr, int target, int left, int right){
        while(left < right){
            int mid = (left + right) / 2;
            if(target > arr[mid])    left = mid+1;
            else right = mid;
        }
        if(arr[left] == target) return 1;
        else return 0;
    }
}