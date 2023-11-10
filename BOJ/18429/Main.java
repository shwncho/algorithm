import java.util.*;
import java.io.*;
public class Main {
    static int n,k;
    static int[] pm,arr;
    static boolean[] checked;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        checked = new boolean[n];
        pm = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i] = Integer.parseInt(st.nextToken());

        DFS(0);

        System.out.println(result);


    }

    static void DFS(int L){
        if(L==n){
            boolean flag = true;
            int num = 500;
            for(int i=0; i<n; i++){
                num+=arr[pm[i]];
                num-=k;

                if(num<500){
                    flag=false;
                    break;
                }
            }

            if(flag)    result++;
        }
        else{
            for(int i=0; i<n; i++){
                if(!checked[i]){
                    checked[i]=true;
                    pm[L]=i;
                    DFS(L+1);
                    checked[i]=false;
                }
            }
        }
    }
}
