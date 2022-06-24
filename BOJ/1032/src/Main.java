import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];


        for(int i=0; i<N; i++){
            str[i]=br.readLine();
        }

        for(int j=0; j<str[0].length(); j++){
            boolean flag = true;
            char x =str[0].charAt(j);
            for(int s=0; s<N-1; s++) {
                if (x != str[s+1].charAt(j)){
                    sb.append("?");
                    flag=false;
                    break;
                }

            }

            if(flag)    sb.append(x);
        }

        System.out.println(sb.toString());

    }
}
