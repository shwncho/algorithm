import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] top = new int[H+1];
        int[] bottom = new int[H+1];

        int min = N;
        int cnt = 0;

        for(int i=0; i<N/2; i++){
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        int[] topSum = new int[H+1];
        int[] bottomSum = new int[H+1];

        for(int i=1; i<H+1; i++){
            topSum[i] = topSum[i-1] + top[i];
            bottomSum[i] = bottomSum[i-1] + bottom[i];
        }

        for(int i=1; i<H+1; i++){
            int crush = 0;

            crush+=bottomSum[H] - bottomSum[i-1];
            crush+=topSum[H] - topSum[H-i];

            if(min > crush){
                min = crush;
                cnt=1;
            }
            else if(min == crush){
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);





    }
}
