import java.util.*;
import java.io.*;

public class Main{
    static int r,c,t;
    static int[][] graph;
    static int cleanerx1=0;
    static int cleanerx2=0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] copyGraph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph=new int[r][c];
        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==-1 && cleanerx1==0)    cleanerx1=i;
                else if(graph[i][j]==-1 && cleanerx1!=0)    cleanerx2=i;
            }
        }

        while(t-->0){
            solution();
        }

        System.out.println(totalSum());
    }

    public static void solution(){
        copyGraph = new int[r][c];

        for(int i=0; i<r; i++){
            copyGraph[i]=graph[i].clone();
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                if(graph[i][j]<5)    continue;

                int spreadCnt=0;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(nx<0 || nx>=r || ny<0 || ny>=c)    continue;

                    if(graph[nx][ny]==-1)    continue;

                    //확산된 방향의 개수
                    spreadCnt++;

                }

                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(nx<0 || nx>=r || ny<0 || ny>=c)    continue;

                    if(graph[nx][ny]==-1)    continue;

                    copyGraph[nx][ny]+=graph[i][j]/5;

                }

                copyGraph[i][j]-=(graph[i][j]/5)*spreadCnt;





            }
        }

        move();

        for(int i=0; i<r; i++){
            graph[i]=copyGraph[i].clone();
        }
    }

    public static void move(){

        //반시계
        int tmp=copyGraph[cleanerx1][c-1];
        for(int i=c-1; i>1; i--){
            copyGraph[cleanerx1][i]=copyGraph[cleanerx1][i-1];
        }
        copyGraph[cleanerx1][1]=0;

        int tmp2 = copyGraph[0][c-1];
        for(int i=0; i<cleanerx1-1; i++){
            copyGraph[i][c-1]=copyGraph[i+1][c-1];
        }
        copyGraph[cleanerx1-1][c-1]=tmp;

        int tmp3 = copyGraph[0][0];

        for(int i=0; i<c-2; i++){
            copyGraph[0][i]=copyGraph[0][i+1];
        }
        copyGraph[0][c-2]=tmp2;

        for(int i=cleanerx1-1; i>1; i--){
            copyGraph[i][0]=copyGraph[i-1][0];
        }
        copyGraph[1][0]=tmp3;

        //시계

        tmp = copyGraph[cleanerx2][c-1];
        for(int i=c-1; i>1; i--){
            copyGraph[cleanerx2][i]=copyGraph[cleanerx2][i-1];
        }
        copyGraph[cleanerx2][1]=0;

        tmp2 = copyGraph[r-1][c-1];

        for(int i=r-1; i>cleanerx2+1; i--){
            copyGraph[i][c-1]=copyGraph[i-1][c-1];
        }

        copyGraph[cleanerx2+1][c-1]=tmp;

        tmp3 = copyGraph[r-1][0];

        for(int i=0; i<c-2; i++){
            copyGraph[r-1][i]=copyGraph[r-1][i+1];
        }
        copyGraph[r-1][c-2]=tmp2;

        for(int i=cleanerx2+1; i<r-2; i++){
            copyGraph[i][0]=copyGraph[i+1][0];
        }
        copyGraph[r-2][0]=tmp3;
    }

    public static int totalSum(){
        int sum=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j]!=-1)    sum+=graph[i][j];
            }
        }
        return sum;
    }

}