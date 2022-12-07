import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt=0,sum=0;
        String str;

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            str=br.readLine();
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)=='O'){
                    cnt++;
                    sum+=cnt;
                }
                else{
                    cnt=0;
                }
            }
            bw.write(Integer.toString(sum));
            bw.write("\n");
            bw.flush();
            sum=0;
            cnt=0;

        }


        br.close();
        bw.close();
    }
}
