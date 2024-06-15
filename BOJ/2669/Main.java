import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        boolean[][] checked = new boolean[101][101];

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1; j<x2; j++){
                for(int k=y1; k<y2; k++){
                    if(!checked[j][k]){
                        checked[j][k]=true;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
