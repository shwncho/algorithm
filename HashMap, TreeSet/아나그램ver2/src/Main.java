import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static String solution(String s1, String s2){
        String answer="YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x:s1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(char x:s2.toCharArray()){
            //key자체가 없거나, -1로 감소 시켰을 때 더이상 없으면 "NO"
            if(!map.containsKey(x) || map.get(x)==0)   return "NO";
            map.put(x, map.get(x)-1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        System.out.println(solution(str1,str2));
    }
}
