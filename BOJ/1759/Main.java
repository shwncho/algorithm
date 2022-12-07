import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static char[] combi;
    static char[] ch;
    static StringBuilder sb=new StringBuilder();
    static void DFS(int L,int s){
        if(L==n){
            if(isValid()){
                for(char x:combi) sb.append(x);
                sb.append("\n");
            }
        }
        else{
            for(int i=s; i<m; i++){
                combi[L]=ch[i];
                DFS(L+1,i+1);
            }
        }
    }
    static boolean isValid(){
        boolean flag1=false;
        int cnt=0;
        for(int i=0; i<n; i++){
            if(combi[i]=='a' || combi[i]=='e' || combi[i]=='i' || combi[i]=='o' || combi[i]=='u') flag1=true;
            else cnt++;
        }
        if(flag1 && cnt>=2) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combi=new char[n];
        ch=new char[m];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)  ch[i]=st.nextToken().charAt(0);

        Arrays.sort(ch);
        DFS(0,0);
        System.out.println(sb);



    }
}
