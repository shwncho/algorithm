import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Stack<Character> stk = new Stack<>();
        while(true){
            String str=br.readLine();
            if(str.equals("."))   break;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)=='(' || str.charAt(i)=='[') {
                    stk.push(str.charAt(i));
                }
                else if(str.charAt(i)==')'){
                    if(!stk.isEmpty()) {
                        if (stk.peek() == '(') stk.pop();
                        else{
                            //][]. 들어오는 경우를 방지
                            sb.append("no").append("\n");
                            break;
                        }
                    }
                    else {
                        //][]. 들어오는 경우를 방지
                        sb.append("no").append("\n");
                        break;
                    }
                }
                else if(str.charAt(i)==']'){
                    if(!stk.isEmpty()) {
                        if (stk.peek() == '[') stk.pop();
                        else{
                            //][]. 들어오는 경우를 방지
                            sb.append("no").append("\n");
                            break;

                        }
                    }
                    else{
                        //][]. 들어오는 경우를 방지
                        sb.append("no").append("\n");
                        break;
                    }
                }
                else if(str.charAt(i)=='.'){
                    if(stk.empty())   sb.append("yes").append("\n");
                    else    sb.append("no").append("\n");
                }

            }
            stk.clear();
        }
        System.out.println(sb);

    }
}
