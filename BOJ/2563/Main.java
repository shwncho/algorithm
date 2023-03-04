import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int total=0;
        int[][] area = new int[101][101];

        for(int k=0; k<n; k++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int i=a; i<a+10; i++){
                for(int j=b; j<b+10; j++){
                    if(area[i][j]==0){
                        area[i][j]=1;
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }
}