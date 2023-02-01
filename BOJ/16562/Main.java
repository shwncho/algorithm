import java.util.*;
import java.io.*;
public class Main {
    static int[] unf;
    static int Find(int v){
        if(v==unf[v])   return unf[v];
        else return unf[v]=Find(unf[v]);
    }

    static void Union(int a, int b, int[] arr){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb){
            //1번과 3번이 친구 관계 맺을 때 1->3, 3->1 두 가지 경우를 고려할 수 있음
            //가장 적은 비용으로 친구가 되야 하므로 친구 비용이 큰 애가 비용이 작은 애와  친구 맺음으로써 친구 비용 적은 경우를 선택
            if(arr[fa] > arr[fb]){
                unf[fa]=fb;
            }
            else unf[fb]=fa;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        //친구 관계
        unf = new int[n+1];
        //친구 비용
        int[] arr = new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a,b,arr);
        }



        int answer=0;
        for(int i=1; i<=n; i++){
            //친구 비용이 적어서 다른 친구들로부터 선택받은 케이스
            if(i==unf[i])   answer+=arr[i];
        }
        if(money<answer) System.out.println("Oh no");
        else System.out.println(answer);



    }
}
