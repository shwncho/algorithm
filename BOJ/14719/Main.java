import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        int tmp = Integer.MIN_VALUE;
        for(int i=0; i<W; i++){
            tmp = Math.max(tmp, arr[i]);
            leftMax[i] = tmp;
        }

        tmp = Integer.MIN_VALUE;
        for(int i=W-1; i>=0; i--){
            tmp = Math.max(tmp, arr[i]);
            rightMax[i] = Math.max(tmp, arr[i]);
        }

        int[] answer = new int[W];
        for(int i=0; i<W; i++){
            int min = Math.min(leftMax[i],rightMax[i]);
            answer[i] = Math.max(min-arr[i], 0);
        }


        System.out.println(Arrays.stream(answer).sum());


    }
}
