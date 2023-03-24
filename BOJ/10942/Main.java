import java.io.*;
import java.util.*;

class Main{
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(checkPalindrome(arr,start,end)) sb.append("1").append("\n");
            else sb.append("0").append("\n");

        }

        System.out.println(sb);


    }

    public static boolean checkPalindrome(int[] arr, int start, int end){

        int s = start-1;
        int e = end-1;
        while(s<=e){
            if(arr[s++]!=arr[e--]){
                return false;
            }
        }

        return true;
    }
}