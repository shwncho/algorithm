import java.util.*;
import java.io.*;

public class Main{
    static int n,L;
    static int[][] graph;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            //행 체크
            if(valid(i,0,'r')){
                answer++;
            }
            //열 체크
            if(valid(0,i,'c')){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean valid(int x, int y, char c){
        boolean[] visited = new boolean[n];

        //2차원 배열 그래프를 1차원 배열에 쉽게 나타내기
        int[] h = new int[n];

        for(int i=0; i<n; i++){
            h[i]=(c=='r') ? graph[x][y+i] : graph[x+i][y];
        }

        for(int i=0; i<n-1; i++){

            //높이가 같을 경우
            if(h[i]==h[i+1])    continue;

            if(Math.abs(h[i]-h[i+1])>1) return false;

            //내려가는경우
            if(h[i]-1==h[i+1]){
                for(int j=i+1; j<=i+L; j++){
                    //그래프 범위를 벗어났거나, 경사로를 놓은 위치거나, 높이가 달라지거나
                    if(j>=n || visited[j] || h[j]!=h[i+1])  return false;

                    visited[j]=true;
                }
            }

            //올라가는경우
            if(h[i]==h[i+1]-1){
                for(int j=i; j>i-L; j--){

                    if(j<0 || visited[j] || h[j]!=h[i+1]-1) return false;

                    visited[j]=true;
                }
            }
        }

        //전부 통과했을경우
        return true;
    }
}