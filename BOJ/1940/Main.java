import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        int left = 0;
        int right = N-1;
        while(left<right){
            if(arr[left]+arr[right]==M){
                answer++;
                left++;
                right--;
            }
            else if(arr[left]+arr[right]<M){
                left++;
            }
            else if(arr[left]+arr[right]>M){
                right--;
            }
        }

        System.out.println(answer);
    }
}
