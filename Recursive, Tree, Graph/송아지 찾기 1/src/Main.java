import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    int[] dis={1,-1,5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s,int e){
        ch=new int[10001];
        ch[s]=1;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int i=0; i<len; i++){
                int x=Q.poll();
                for(int j=0; j<3; j++){
                    int nx=x+dis[j];
                    if(nx>=1 && nx<=10000 && nx ==e)    return L+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0; //위 로직에서 정답을 못찾았을 경우
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(T.BFS(s,e));
        br.close();
    }

}
