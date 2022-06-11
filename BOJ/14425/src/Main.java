import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt=0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> s = new HashSet<>();

        for(int i=0; i<n; i++){
            s.add(br.readLine());
        }


        for(int j=0; j<m; j++){
            String str = br.readLine();
            if(s.contains(str)) cnt++;
        }


        System.out.println(cnt);
    }
}
