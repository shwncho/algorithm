import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        double[] ch = new double[N];

        for(int i=0; i<N; i++){
            ch[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(0<=c-'A' && c-'A'<=26)   stk.push(ch[c-'A']);
            else{
                double a = stk.pop();
                double b = stk.pop();
                if(c=='+')  stk.push(b+a);
                else if(c=='-') stk.push(b-a);
                else if(c=='*') stk.push(b*a);
                else stk.push(b/a);
            }

        }

        System.out.printf("%.2f",stk.pop());
    }
}
