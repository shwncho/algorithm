import java.util.*;
import java.io.*;
class Point{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int[][] graph;
    static ArrayList<Point> list = new ArrayList<>();
    public static boolean rowCheck(int row, int num){
        for(int i=0; i<9; i++) {
            if (graph[row][i] == num) return false;
        }
        return true;
    }

    public static boolean columnCheck(int col, int num){
        for(int i=0; i<9; i++){
            if(graph[i][col]==num)  return false;
        }
        return true;
    }

    public static boolean squareCheck(int row, int col, int num){
        int x = row/3 * 3;
        int y = col/3 * 3;
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(graph[i][j]==num)  return false;
            }
        }
        return true;
    }

    public static void solution(int pos){
        if(pos==list.size()){
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(graph[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            //더 이상 재귀하지 않고 여기서 프로그램 종료시키는 것이 핵심
            System.exit(0);
        }

        int x = list.get(pos).x;
        int y = list.get(pos).y;

        for(int num=1; num<=9; num++){
            if(rowCheck(x,num) && columnCheck(y,num) && squareCheck(x,y,num)){
                graph[x][y]=num;
                solution(pos+1);
                graph[x][y]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph=new int[9][9];

        for(int i=0; i<9; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==0)  list.add(new Point(i,j));
            }
        }

        solution(0);

    }
}
