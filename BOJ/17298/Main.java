import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stk = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty()){
                if(arr[i] < stk.peek()){
                    answer[i] = stk.peek();
                    break;
                }
                else stk.pop();
            }

            if(stk.isEmpty())   answer[i] = -1;
            stk.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer){
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}
