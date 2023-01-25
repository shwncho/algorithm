import java.util.*;
import java.io.*;

public class Main {
    static int[] ch = new int[100001];
    static int min = Integer.MAX_VALUE;
    static int answer = 0;
    static Queue<Integer> Q = new LinkedList<>();
    public static void BFS(int s, int e){
        Q.offer(s);
        ch[s]=1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();

                //현재 시간이 최소 도달 시간보다 크면 전부 skip
                if(min < ch[x]) return;

                for(int j=0; j<3; j++){
                    int nx = 0;

                    if(j==0)    nx=x-1;
                    else if(j==1) nx=x+1;
                    else nx=x*2;

                    if(nx<0 || nx>100000)   continue;

                    if(nx==e){
                        min = ch[x];
                        answer++;
                    }

                    //가보지 않은 곳 or 동일한 시간대에 움직이는지 체크
                    if( ch[nx]==0 || ch[nx]==ch[x]+1){
                        Q.offer(nx);
                        ch[nx]=ch[x]+1;
                    }

                }

            }

        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if(s>=e){
            System.out.println((s-e)+"\n1");
            return;
        }
        BFS(s,e);

        System.out.println(min);
        System.out.println(answer);




    }
}
