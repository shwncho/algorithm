import java.util.Scanner;

public class Main {
    static int answer=0;
    static int[][] graph;
    static int[] dx={-1,0,1,0}; // 12시 3시 6시 9시 시계방향순서로 x값의 변화
    static int[] dy={0,1,0,-1};
    public void DFS(int x, int y){
        if(x==7 && y==7)    answer++;
        else{
            for(int i=0; i<4; i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                if(nextX>=1 && nextX<=7 && nextY>=1 && nextY<=7 && graph[nextX][nextY]==0){
                    graph[x][y]=1;
                    DFS(nextX,nextY);
                    graph[x][y]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        graph = new int[8][8];

        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                graph[i][j]=sc.nextInt();
            }
        }

        graph[1][1]=1;
        T.DFS(1,1);
        System.out.println(answer);
    }
}
