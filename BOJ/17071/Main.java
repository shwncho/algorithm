import java.util.*;
import java.io.*;

public class Main {
    public static int BFS(int s, int e){
        int[][] ch = new int[500001][2];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int len,mod,time=0;
        while(!Q.isEmpty()){
            len = Q.size();
            time++;
            mod=time%2;
            for(int i=0; i<len; i++){
                int x = Q.poll();

                for(int j=0; j<3; j++){
                    int nx;
                    if(j==0)    nx=x*2;
                    else if(j==1)   nx=x+1;
                    else nx=x-1;

                    if(nx<0 || nx>500000)   continue;

                    if(ch[nx][mod]==0){
                        Q.offer(nx);
                        ch[nx][mod]=time;
                    }
                }
            }
            int ne =e+sum(time);
            if(ne>500000)   return -1;
            if(ch[ne][mod]!=0)  return time;


        }
        return -1;
    }

    public static int sum(int n){
        int s=0;
        for(int i=1; i<=n; i++){
            s+=i;
        }
        return s;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println((s==e) ? 0 : BFS(s,e));


    }
}