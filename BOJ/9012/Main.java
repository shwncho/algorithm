import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static String solution(String s){
        String answer="";
        Stack stk = new Stack();
        for(char x:s.toCharArray()){
            if(x=='(')  stk.push(x);
            else if(x==')') {
                if (stk.isEmpty()) return "NO";
                stk.pop();
            }
        }
        if(stk.isEmpty())   answer="YES";
        else    answer="NO";

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> str = new ArrayList<>();
        for(int i=0; i<n; i++){
            str.add(solution(sc.next()));
        }

        for(String x:str){
            System.out.println(x);
        }

    }
}

