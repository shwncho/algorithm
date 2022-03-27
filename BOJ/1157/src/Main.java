import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character,Integer> map = new HashMap<>();
        Integer max;
        ArrayList<Character> arr = new ArrayList<>();

        String s = br.readLine();
        s=s.toUpperCase();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        max=map.entrySet()
                .stream()
                .max((entry1,entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        for (Character ch : map.keySet()) {
            if(map.get(ch).equals(max))    arr.add(ch);
        }

        if(arr.size()>1) bw.write("?");
        else bw.write(arr.get(0));

        br.close();
        bw.flush();
        bw.close();


    }
}
