import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int cnt;
    static int[] arr = {1,2,3};
    static int[] pm;
    static void DFS(int L, int m){
        if(L==m){
            int sum=0;
            for(int x : pm)    sum+=x;
            if(sum==n)    cnt++;
        }
        //중복순열
        else{
            for(int i=0; i<3; i++){
                pm[L]=arr[i];
                DFS(L+1,m);

            }
        }


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            n= Integer.parseInt(br.readLine());
            cnt=0;
            pm=new int[n];

            //1개~n개로 숫자 n을 만들 수 있는 경우
            for(int j=1; j<=n; j++)    DFS(0,j);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
