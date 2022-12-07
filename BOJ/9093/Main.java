import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            Stack<Character> stk = new Stack<>();
            String s = br.readLine();

            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)==' '){
                    while(!stk.isEmpty()) bw.write(stk.pop());
                    bw.write(" ");
                }
                else{
                    stk.push(s.charAt(j));
                }
            }
            while(!stk.isEmpty()){
                bw.write(stk.pop());
            }
            bw.write("\n");
            //System.out.println();
        }
        br.close();
        bw.close();

    }
}
