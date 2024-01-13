import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         char[] chars1 = br.readLine().toCharArray();
         char[] chars2 = br.readLine().toCharArray();

         int[] num = new int[26];

         for(int i=0; i<chars1.length; i++){
             num[chars1[i]-'a']++;
         }

         for(int i=0; i<chars2.length; i++){
             num[chars2[i]-'a']--;
         }

         int sum = 0;
         for(int i=0; i<26; i++){
             int tmp = Math.abs(num[i]);
             if(tmp!=0){
                 sum+=tmp;
             }
         }

        System.out.println(sum);

    }
}
