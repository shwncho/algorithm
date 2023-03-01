import java.util.*;
import java.io.*;

public class Main{
    static int[][] graph= new int[5][5];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> list = new ArrayList<>();
    static void DFS(int L,int[] arr, int x, int y){
        if(L==6){
            int result=0;
            for(int t : arr){
                result=result*10+t;
            }
            if(!list.contains(result))  list.add(result);
        }
        else{
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || nx>=5 || ny<0 || ny>=5)    continue;

                arr[L]=graph[nx][ny];
                DFS(L+1,arr,nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                int[] arr = new int[6];
                DFS(0,arr,i,j);

            }
        }

        System.out.println(list.size());

    }
}