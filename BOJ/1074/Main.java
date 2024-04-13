import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solve(N,r,c));
    }

    private static int solve(int N, int r, int c){
        if(N==0)    return 0;

        //4분면에서 0,1,2,3 에서 어느 위치인지 + 원소의 r,c를 2배 확장시키면 4배 원소
        return 2*(r%2) + (c%2) + 4 * (solve(N-1,r/2,c/2));
    }
}
