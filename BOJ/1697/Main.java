import java.util.*;
import java.io.*;
public class Main {
    static Queue<Integer> Q = new LinkedList<>();
    public static int BFS(int s , int e){
        if(s==e)    return 0;
        int[] ch = new int[100001];
        ch[s]=1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx=0;
                    if(j==0) nx=x-1;
                    else if(j==1)   nx=x+1;
                    else nx=x*2;

                    if(nx>=0 && nx<=100000 && nx==e) return L+1;
                    else if(nx>=0 && nx<=100000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
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
