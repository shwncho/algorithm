import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static void DFS(int L,int num){
        //A-B-C-D-E는 4개의 연결줄이 필요
        if(L==4){
            System.out.println(1);
            System.exit(0);
        }
        else{
            visited[num]=true;
            int size = list.get(num).size();
            for(int i=0; i<size; i++){
                int tmp = list.get(num).get(i);
                if(!visited[tmp]){
                    visited[tmp]=true;
                    DFS(L+1,tmp);
                    visited[tmp]=false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0; i<n; i++){
            visited = new boolean[n];
            DFS(0,i);

        }

        System.out.println(0);



    }
}