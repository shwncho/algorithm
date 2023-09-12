import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)  arr[i]=Integer.parseInt(st.nextToken());

        int[] ps = new int[n+1];

        for(int i=1; i<=n; i++) ps[i]=ps[i-1]+arr[i-1];

        StringBuilder sb = new StringBuilder();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(ps[j]-ps[i-1]).append("\n");
        }

        System.out.println(sb);
    }
}
