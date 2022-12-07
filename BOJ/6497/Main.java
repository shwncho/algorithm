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
        return this.cost - o.cost;
    }
}
public class Main {
    static int[] unf;
    static int n,m;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int v1, int v2){
        int fv1 = Find(v1);
        int fv2 = Find(v2);
        if(fv1!=fv2)    unf[fv1]=fv2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            unf=new int[n];
            ArrayList<Edge> list = new ArrayList<>();
            for(int i=0; i<n; i++)  unf[i]=i;

            int totalCost=0;
            for(int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                totalCost += c;
                list.add(new Edge(a, b, c));
            }

            int answer=0;
            Collections.sort(list);
            for(Edge o : list){
                int fv1=Find(o.v1);
                int fv2=Find(o.v2);
                if(fv1!=fv2){
                    answer+=o.cost;
                    Union(fv1,fv2);
                }

            }
            System.out.println(totalCost-answer);
        }


    }
}
