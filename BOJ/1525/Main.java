import java.util.*;
import java.io.*;

/**
 * 1. String을 통한 BFS 탐색
 * 2. Map을 이용하여 탐색 및 결과값 기록
 */
public class Main{
    static String result = "123456780";
    static Map<String,Integer> map = new HashMap<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static int BFS(String init){
        Queue<String> q = new LinkedList<>();
        q.offer(init);

        while(!q.isEmpty()){
            String s = q.poll();

            int cnt = map.get(s);
            int empty = s.indexOf("0");
            int x = empty/3;
            int y = empty%3;

            if(s.equals(result))    return cnt;
            for(int i=0; i<4 ;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>2 || ny<0 || ny>2)    continue;

                int target = nx*3 + ny;
                char tmp = s.charAt(target);
                //s는 다른 방향에서도 탐색해줘야 하므로 새로운 String 객체 생성해서 담는다.
                String next=s.replace(tmp,'c');
                next=next.replace('0',tmp);
                next=next.replace('c','0');

                if(!map.containsKey(next)){
                    q.offer(next);
                    map.put(next,cnt+1);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String init="";

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int n = Integer.parseInt(st.nextToken());
                init+=n;
            }
        }
        map.put(init,0);
        System.out.println(BFS(init));
    }
}