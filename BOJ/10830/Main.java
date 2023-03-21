import java.util.*;
import java.io.*;

public class Main {
    final static int MOD = 1000;
    static int n;
    static int[][] origin;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        origin = new int[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                origin[i][j]=Integer.parseInt(st.nextToken())%MOD;
            }
        }

        int[][] result = pow(origin,m);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int[][] pow(int[][] A, long exp){

        if(exp==1L || exp==0){
            return A;
        }

        int[][] ret = pow(A,exp/2);

        ret=multiply(ret,ret);

        if(exp%2!=0){
            ret=multiply(ret,origin);
        }

        return ret;

    }
    public static int[][] multiply(int[][] o1, int[][] o2){
        int[][] ret = new int[n][n];

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    ret[i][j]+=o1[i][k]*o2[k][j];
                    ret[i][j]%=MOD;
                }
            }
        }

        return ret;
    }
}
