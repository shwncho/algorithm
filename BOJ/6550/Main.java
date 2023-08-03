import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String input = "";

        while((input=br.readLine())!=null){
            st = new StringTokenizer(input);
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();

            int sIdx = 0;
            for(int i=0; i<t.length; i++){
                if(t[i] == s[sIdx]){
                    sIdx++;
                }
                if(sIdx == s.length)    break;
            }

            if(sIdx == s.length) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");
        }
        System.out.println(sb);



    }
}
