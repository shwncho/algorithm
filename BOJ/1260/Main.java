import java.util.*;

public class Main {
    static int n,m,s;
    static int[] ch1,ch2;
    static ArrayList<ArrayList<Integer>> graph;

    public void DFS(int v){
        System.out.print(v+" ");
        for(int nv : graph.get(v)){
            if(ch1[nv]==0){
                ch1[nv]=1;
                DFS(nv);
            }
        }
    }

    public void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int cv = Q.poll();
                System.out.print(cv+" ");
                for(int nv : graph.get(cv)){
                    if(ch2[nv]==0){
                        ch2[nv]=1;
                        Q.offer(nv);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        ch1=new int[n+1];
        ch2=new int[n+1];

        graph=new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(graph.get(i));
        }

        ch1[s]=ch2[s]=1;
        T.DFS(s);
        System.out.println();
        T.BFS(s);
    }
}
