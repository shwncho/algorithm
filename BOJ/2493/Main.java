import java.io.*;
import java.util.*;
public class Main {

    static class Node{
        public int value, idx;
        Node(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] answer = new int[n];

        Stack<Node> stk = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){

            while(!stk.isEmpty()){
                if(arr[i] < stk.peek().value){
                    answer[i] = stk.peek().idx;
                    break;
                }
                else stk.pop();
            }

            if(stk.isEmpty())   answer[i]=0;

            stk.push(new Node(arr[i],i+1));
        }

        StringBuilder sb = new StringBuilder();
        for(int x : answer) sb.append(x).append(" ");
        System.out.println(sb);
    }
}
