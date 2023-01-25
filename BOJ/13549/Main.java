import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
    public int x,time;
    Pair(int x, int time){
        this.x=x;
        this.time=time;
    }

    @Override
    public int compareTo(Pair p){
        return this.time - p.time;
    }
}
public class Main {
    static int[] ch = new int[100001];
    public static int BFS(int s, int e){
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        Q.offer(new Pair(s,0));
        while(!Q.isEmpty()){
            Pair tmp = Q.poll();
            //3가지 케이스 마다 다음 이동 지점을 체크하면 어떤 연산을 먼저 놓느냐에 따라 최소시간이 바뀌므로, 현재 지점을 체크
            ch[tmp.x]=1;
            if(tmp.x==e)    return tmp.time;

            if(tmp.x*2<=100000 && ch[tmp.x*2]==0){
                Q.offer(new Pair(tmp.x*2, tmp.time));
            }

            if(tmp.x+1<=100000 && ch[tmp.x+1]==0){
                Q.offer(new Pair(tmp.x+1,tmp.time+1));
            }

            if(tmp.x-1>=0 && ch[tmp.x-1]==0){
                Q.offer(new Pair(tmp.x-1, tmp.time+1));
            }


        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        if(s>=e){
            System.out.println(s-e);
            return;
        }
        System.out.println(BFS(s,e));
    }
}
