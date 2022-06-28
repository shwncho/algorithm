import java.util.ArrayList;
import java.util.Scanner;

/**
 * 정점이 많을 때, 행렬로 구현하면 100000*100000일 경우 메모리 낭비 심하므로
 * ArrayList 방식으로 구현
 */
public class Main {
    static int n,m,answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n)    answer++;
        else{
            for(int nv : graph.get(v)){
                if (ch[nv] == 0) {
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);

        System.out.println(answer);
    }
}
