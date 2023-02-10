import java.util.*;
import java.io.*;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int solution(String dirs) {
        boolean[][][][] visited = new boolean[11][11][11][11];
        int answer=0;
        int cx=5;
        int cy=5;
        char[] ch = dirs.toCharArray();
        for( char c : ch){
            int nx=0;
            int ny=0;
            if(c=='U'){
                nx=cx-1;
                ny=cy;
            }
            else if(c=='D'){
                nx=cx+1;
                ny=cy;
            }
            else if(c=='R'){
                ny=cy+1;
                nx=cx;
            }
            else{
                ny=cy-1;
                nx=cx;
            }


            if(nx<0 || nx>=11 || ny<0 || ny>=11)    continue;

            //양방향 체크 핵심
            if(!visited[cx][cy][nx][ny] && !visited[nx][ny][cx][cy]){
                visited[cx][cy][nx][ny]=true;
                visited[nx][ny][cx][ny]=true;
                answer++;
                cx=nx;
                cy=ny;
            }
            else{
                cx=nx;
                cy=ny;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("ULURRDLLU"));
    }
}
