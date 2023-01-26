import java.util.*;
import java.io.*;
public class Main {
    static Queue<Integer> Q = new LinkedList<>();
    public static int BFS(int s , int e){
        int[] ch = new int[100001];
        ch[s]=1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();

                if(x == e)  return L;

                if(x-1>=0 && ch[x-1]==0){
                    ch[x-1]=1;
                    Q.offer(x-1);
                }
                if(x+1>=0 && x+1<=100000 && ch[x+1]==0){
                    ch[x+1]=1;
                    Q.offer(x+1);
                }
                if(x*2>=0 && x*2<=100000 && ch[x*2]==0){
                    ch[x*2]=1;
                    Q.offer(x*2);
                }

            }
            L++;
        }
        //도착지점에 못 도달하는 경우
        return 0;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(BFS(s,e));
    }
}
