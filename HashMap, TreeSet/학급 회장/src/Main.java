import java.util.*;

public class Main {
    public char solution(int n, String s){
        char answer;
        char[] c = s.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char x =c[i];
            if(hm.containsKey(x))   hm.put(x,hm.get(x)+1);
            else{
                hm.put(x,0);
            }
        }
        Map.Entry<Character,Integer> maxEntry = null;

        Set<Map.Entry<Character,Integer>> entrySet = hm.entrySet();
        for(Map.Entry<Character,Integer> entry: entrySet){
            if(maxEntry==null || entry.getValue() > maxEntry.getValue()){
                maxEntry=entry;
            }
        }
        answer= maxEntry.getKey();
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n,str));

    }
}
