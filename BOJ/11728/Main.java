import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];
        int[] answer = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)  B[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int idx = 0;
        while(left < N && right < M){
            if(A[left] >= B[right]){
                answer[idx++] = B[right++];
            }
            else answer[idx++] = A[left++];
        }

        while(left<N)   answer[idx++]=A[left++];
        while(right<M)  answer[idx++]=B[right++];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N+M; i++)    sb.append(answer[i]).append(" ");


        System.out.println(sb);
        br.close();

    }
}
