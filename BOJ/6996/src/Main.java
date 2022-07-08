import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static boolean solution(String s1, String s2){
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();

        for(Character x : s1.toCharArray()){
            h1.put(x, h1.getOrDefault(x,0)+1);
        }

        for(Character x : s2.toCharArray()){
            h2.put(x, h2.getOrDefault(x,0)+1);
        }

        for(Character x : h1.keySet()){
            if(!h1.get(x).equals(h2.get(x)))    return false;
        }

        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1,s2;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            s1=st.nextToken();
            s2=st.nextToken();

            System.out.println(s1+" & " + s2+" are " + (solution(s1,s2) ? " anagrams.":" NOT anagrams."));


        }

    }
}
