import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] chars = br.readLine().toCharArray();

        int[] condition = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)  condition[i] = Integer.parseInt(st.nextToken());

        int cntA = 0;
        int cntC = 0;
        int cntG = 0;
        int cntT = 0;

        int answer = 0;

        for(int i=0; i<P; i++){
            switch (chars[i]){
                case 'A': cntA++;
                    break;
                case 'C': cntC++;
                    break;
                case 'G': cntG++;
                    break;
                case 'T': cntT++;
                    break;
            }
        }

        if(cntA >= condition[0] && cntC>= condition[1] &&
                cntG>=condition[2] && cntT>=condition[3]) answer++;



        int start = 0;
        for(int end = P; end<S; end++){
            switch (chars[end]){
                case 'A': cntA++;
                    break;
                case 'C': cntC++;
                    break;
                case 'G': cntG++;
                    break;
                case 'T': cntT++;
                    break;
            }

            switch (chars[start++]){
                case 'A': cntA--;
                    break;
                case 'C': cntC--;
                    break;
                case 'G': cntG--;
                    break;
                case 'T': cntT--;
                    break;
            }


            if(cntA >= condition[0] && cntC>= condition[1] &&
                    cntG>=condition[2] && cntT>=condition[3]) answer++;

        }

        System.out.println(answer);
        br.close();
    }
}
