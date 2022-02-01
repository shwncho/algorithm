import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int solution(String s, String t){
        int answer=0,p=0,e;
        char[] ch = s.toCharArray();
        char[] ch2 = t.toCharArray();
        HashMap<Character,Integer> tm = new HashMap<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            tm.put(ch2[i],tm.getOrDefault(ch2[i],0)+1);
        }

        for(e=0; e<s.length(); e++){
            map.put(ch[e],map.getOrDefault(ch[e],0)+1);
            if(e>=t.length()-1){
                if(tm.equals(map))  answer++;
                if(map.get(ch[p])==1)   map.remove(ch[p]);
                else    map.put(ch[p],map.get(ch[p])-1);
                p++;
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =sc.next();
        String t =sc.next();
        System.out.println(solution(s,t));
    }
}
