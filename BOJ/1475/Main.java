import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");

        Map<Integer, Integer> map = new HashMap<>();


        for(int i=0; i<10; i++){
            map.put(i,0);
        }

        for(int i=0; i<str.length; i++){
            int num = Integer.parseInt(str[i]);
            if(num==6 || num==9){
                if(map.get(6)<=map.get(9))   map.put(6,map.get(6)+1);
                else map.put(9,map.get(9)+1);
            }
            else map.put(num,map.get(num)+1);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<10; i++){
            max = Math.max(max ,map.get(i));
        }
        System.out.println(max);

    }
}
