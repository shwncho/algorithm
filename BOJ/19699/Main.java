import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N,M;
    static TreeSet<Integer> answer = new TreeSet<>();
    static int[] tmp;
    static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        tmp = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  arr[i] = Integer.parseInt(st.nextToken());
        combi(arr, 0,0);

        if(answer.size()!=0)    for(int x : answer) System.out.print(x+" ");
        else System.out.println(-1);

    }

    public static void combi(int[] arr, int L, int s){
        if(L==M){
            int sum = 0;
            for(int i=0; i<M; i++){
                sum+=tmp[i];
            }
            if(isPrime(sum))    answer.add(sum);
        }
        else{
            for(int i=s; i<N; i++){
                tmp[L] = arr[i];
                combi(arr,L+1,i+1);
            }
        }
    }

    public static boolean isPrime(int n){
        if(n==1)    return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)  return false;
        }
        return true;
    }
}
