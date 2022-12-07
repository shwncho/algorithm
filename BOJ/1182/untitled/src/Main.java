import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] num;
    static int n,s;
    static int cnt=0;
    static void DFS(int L, int sum){
        if(L==n){
            if(sum==s)  cnt++;
            return;
        }
        DFS(L+1,sum+num[L]);
        DFS(L+1,sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        num=new int[n];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        DFS(0,0);
        System.out.println(s==0 ? cnt-1 : cnt);



    }
}
