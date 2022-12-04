import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] ch,pm;
    static StringBuilder sb = new StringBuilder();
    static void DFS(int L){
        if(L==n){
            for(int x : pm) sb.append(x).append(" ");
            sb.append("\n");
        }
        else{
            for(int i=0; i<n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L]=i+1;
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());

        ch=new int[n];
        pm=new int[n];

        DFS(0);
        System.out.println(sb);



    }
}
