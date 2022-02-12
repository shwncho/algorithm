import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static String solution(String s1, String s2){
        String answer="";
        Queue<Character> qu = new LinkedList<>();
        for(char x: s1.toCharArray())   qu.offer(x);
        for(char x: s2.toCharArray()){
            if(qu.contains(x)){
                if(x!=qu.poll())    return "NO";
            }
        }
        if(!qu.isEmpty())   return "NO";
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(solution(s1,s2));
    }
}
