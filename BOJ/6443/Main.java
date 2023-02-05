import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n,m;
    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb;
    static char[] pm,arr;
    static int[] visited;
    static void DFS(int L){
        if(L==m){
            for(char x : pm)    sb.append(x);
            sb.append("\n");
        }
        else{
            char[] checked = new char[26];
            for(int i=0; i<m; i++){
                if(visited[i]!=1 && checked[arr[i]-97]!=1){
                    checked[arr[i]-97]=1;
                    visited[i]=1;
                    pm[L]=arr[i];
                    DFS(L+1);
                    visited[i]=0;

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            list.add(br.readLine());
        }

        for(int i=0; i<n; i++){
            m=list.get(i).length();
            sb=new StringBuilder();
            pm=new char[m];
            arr=list.get(i).toCharArray();
            Arrays.sort(arr);
            visited=new int[m];
            DFS(0);
            System.out.print(sb);
        }





    }
}
