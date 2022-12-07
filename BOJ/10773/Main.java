import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stk = new Stack<>();
        int total=0;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());
            if(t!=0){
                stk.push(t);
            }
            else{
                stk.pop();
            }
        }
        while(!stk.isEmpty()){
            total+=stk.pop();
        }
        System.out.print(total);

    }
}
