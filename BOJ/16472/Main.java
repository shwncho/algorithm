import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();
        int[] checked = new int[26];

        int cnt = 0;
        int left = 0;
        int right = 0;

        checked[chars[right]-'a']++;
        cnt++;

        int max = Integer.MIN_VALUE;
        while(true){

            //같은 right 값으로 로직을 처리하기위해 여기서 ++처리하고, 초기값은 반복문 돌기전에 처리
            right++;
            if(right==chars.length) break;

            checked[chars[right]-'a']++;
            if(checked[chars[right]-'a']==1){
                cnt++;
            }


            while(cnt>N){
                checked[chars[left]-'a']--;
                if(checked[chars[left]-'a']==0) cnt--;
                left++;
            }

            max = Math.max(max,right-left+1);
        }


        System.out.println(max);
    }
}
