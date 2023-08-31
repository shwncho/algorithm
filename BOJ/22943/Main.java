import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static final int LIMIT = 98765;
    static ArrayList<Integer> pn = new ArrayList<>();
    static HashSet<Integer> pnSum = new HashSet<>();
    static HashSet<Integer> pnMult = new HashSet<>();
    static boolean[] v = new boolean[10];
    static int k,m;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        find();
        calculate();
        DFS(0,0);

        System.out.println(answer);
    }

    //k가지의 경우의 수 고려
    public static void DFS(int L, int cur){
        if (L == k) {
            if (isValid(cur))
                answer++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (i==0 && L==0 || v[i]) continue;
            v[i] = true;
            DFS(L+1, cur*10+i);
            v[i] = false;
        }
    }

    //소수 배열 생성
    public static void find(){
        int[] check = new int[LIMIT+1];
        for(int i=2; i<=LIMIT; i++){
            if(check[i]==0){
                pn.add(i);
                for(int j=i; j<=LIMIT; j=j+i)   check[j]=1;
            }
        }

    }

    // 2-1번의 조건 계산
    public static void calculate(){
        for (int i = 0; i < pn.size(); i++) {
            for (int j = i; j < pn.size(); j++) {
                int pn1 = pn.get(i);
                int pn2 = pn.get(j);
                long multi = (long) pn1*pn2;
                if (multi <= LIMIT)
                    pnMult.add((int)multi);
                if (pn1!=pn2) {
                    int sum = pn1+pn2;
                    if (sum <= LIMIT)
                        pnSum.add(sum);
                }
            }
        }
    }

    public static boolean isValid(int cur) {
        if (!pnSum.contains(cur)) return false;
        while (cur%m==0)
            cur/=m;
        if (!pnMult.contains(cur)) return false;
        return true;
    }

}
