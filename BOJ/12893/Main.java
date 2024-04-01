import java.io.*;
import java.util.*;
public class Main {
    static int[] u,enemy;
    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        u = new int[N+1];
        enemy = new int[N+1];
        for(int i=1; i<=N; i++) u[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int fa = Find(a);
            int fb = Find(b);

            if(fa==fb){
                flag = true;
                break;
            }

            //양방향으로 적대 관계 연결

            int enemyA = enemy[a];
            int enemyB = enemy[b];

            //적이 존재한다면
            if(enemyA!=0){
                //A의 모든 적들을 B의 친구
                Union(enemyA,b);
            }
            else    enemy[a]=b;

            if(enemyB!=0){
                Union(enemyB, a);
            }
            else enemy[b]=a;
        }

        if(flag) System.out.println(0);
        else System.out.println(1);

    }

    private static int Find(int v){
        if(v==u[v]) return v;
        else return u[v] = Find(u[v]);
    }

    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) u[fa]=fb;
    }
}
