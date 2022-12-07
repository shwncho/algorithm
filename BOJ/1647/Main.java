import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost){
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost-o.cost;
    }
}
public class Main {
    static int[] unf;
    static int Find(int v){
        if(v==unf[v])   return v;
        else return unf[v]=Find(unf[v]);
    }
    static void Union(int a, int  b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)  unf[fa]=fb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Edge> list=new ArrayList<>();

        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));
        }

        int answer=0;
        int max = Integer.MIN_VALUE;
        Collections.sort(list);

        for(Edge o : list){
            int fv1 = Find(o.v1);
            int fv2 = Find(o.v2);
            if(fv1!=fv2){
                answer+=o.cost;
                Union(o.v1,o.v2);
                max=Math.max(max,o.cost);
            }
        }

        //마을을 분할하는 기준은 가장 큰 cost 유지비를 갖는 간선을 제거
        System.out.println(answer-max);
    }
}
