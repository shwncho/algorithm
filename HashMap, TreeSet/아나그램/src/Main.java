import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static String solution(String s1, String s2){
        String answer="";
        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();

        for(char x:s1.toCharArray()){
            m1.put(x, m1.getOrDefault(x,0)+1);
        }

        for(char x:s2.toCharArray()){
            m2.put(x,m2.getOrDefault(x,0)+1);
        }

        for(char key:m1.keySet()){
            if(m1.get(key)!=m2.get(key))    return "NO";

        }
        answer="YES";

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1,str2));
    }
}
