import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Replace 방식은 내부적으로 Garbage Collection을 많이 생성하므로 메모리초과
 * ->Stack 이용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stk = new Stack<>();
        String str = br.readLine();
        String b = br.readLine();
        StringBuilder sb = new StringBuilder();


        for(int i=0; i<str.length(); i++){
            stk.push(str.charAt(i));

            if(stk.size()>=b.length()){
                boolean flag =true;
                for(int j=0; j<b.length(); j++){
                    if(stk.get(stk.size() - b.length() + j)!=b.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag==true){
                    for(int k=0; k<b.length(); k++){
                        stk.pop();
                    }
                }
            }
        }

        if(stk.size()==0){
            sb.append("FRULA");
        }
        else{
            for (Character x : stk) {
                sb.append(x);
            }
        }

        System.out.println(sb.toString());

    }
}
