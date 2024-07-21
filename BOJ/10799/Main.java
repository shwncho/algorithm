import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int answer = 0;
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i<chars.length; i++){
            //레이저 일 때
            if(chars[i] == '(' && chars[i+1]==')'){
                answer+=stk.size();
                i++;
            }
            //쇠막대기 시작 일 때
            else if(chars[i]=='('){
                stk.push(chars[i]);
            }
            //쇠막대기 끝 일 때
            else{
                answer++;
                stk.pop();
            }
        }

        System.out.println(answer);
    }
}
