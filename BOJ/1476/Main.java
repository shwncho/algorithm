import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e=0,s=0,m=0;
        int cnt=0;
        int b=0;


        while(true){
            ++cnt;

            b=cnt/28;

            e=(cnt%15==0)?15:cnt%15;
            s=(cnt%28==0)?28:cnt%28;
            m=(cnt%19==0)?19:cnt%19;


            if(e==E && s==S && m==M){
                break;
            }
        }

        if(s==28) System.out.println(b*28);
        else System.out.println(b*28+s);

    }
}
