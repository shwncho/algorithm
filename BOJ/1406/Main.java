import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for(int i=0; i<str.length(); i++)   leftStack.push(str.charAt(i));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            char cmd = st.nextToken().charAt(0);

            if(cmd=='L'){
                if(!leftStack.isEmpty()){
                    rightStack.push(leftStack.pop());
                }
            }
            else if(cmd=='D'){
                if(!rightStack.isEmpty()){
                    leftStack.push(rightStack.pop());
                }
            }
            else if(cmd=='B'){
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }
            }
            else{
                char t = st.nextToken().charAt(0);
                leftStack.push(t);
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();

        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);

    }
}