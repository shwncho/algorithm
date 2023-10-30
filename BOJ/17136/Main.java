import java.util.*;
import java.io.*;
public class Main {
    static int[][] graph = new int[10][10];
    static int[] numbers = {0,5,5,5,5,5};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0,0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void DFS(int x, int y, int cnt){
        // 맨 끝 종료
        if(x>=9 && y>9){
            answer = Math.min(answer, cnt);
            return;
        }

        // 이미 더 적은 값이 기록되어 있으면 종료
        if(answer < cnt) return;

        if(y>9){
            DFS(x+1, 0, cnt);
            return;
        }

        if(graph[x][y]==1){
            //그리디한 사고로 붙였다 땠다 반복
            for(int i=5; i>=1; i--){
                if(numbers[i]>0 && isAttach(x,y,i)){
                    numbers[i]--;
                    attach(x,y,i,0);  // 색종이 붙임
                    DFS(x,y+1,cnt+1);
                    attach(x,y,i,1); // 붙였던 색종이 제거
                    numbers[i]++;
                }
            }
        }
        else{
            DFS(x,y+1,cnt);
        }

    }

    private static void attach(int x, int y, int size, int state){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                graph[i][j]=state;
            }
        }
    }

    private static boolean isAttach(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(i<0 || i>=10 || j<0 || j>=10)    return false;
                if(graph[i][j]==0)  return false;
            }
        }

        return true;
    }

}
