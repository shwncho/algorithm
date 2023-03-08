import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int target = Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());

        boolean[] remove = new boolean[10];

        //고장난 번호
        if (m != 0) {
            st=new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                int tmp = Integer.parseInt(st.nextToken());
                remove[tmp]=true;
            }
        }

        //완전 탐색, 9빼고 다 고장날 경우 999999번을 눌러야 하는 조건으로 범위 설정
        int result = Math.abs(target-100);
        for(int i=0; i<=999999; i++){
            //i라는 번호를 누를 수 있는지 체크가 필요
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = false;
            for(int j=0; j<len; j++){
                if(remove[str.charAt(j)-'0']){
                    flag=true;
                    break;
                }
            }
            if(flag)    continue;

            result=Math.min(result,Math.abs(target-i)+len);
        }

        System.out.println(result);

    }
}
