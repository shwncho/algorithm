import java.util.Scanner;

public class Main {
    static int n,f;
    static int[] pm,ch;
    static int[][] dy=new int[11][11];
    static boolean flag=false;
    public void DFS(int L){
        if(flag)    return;
        if(L==n) {
            int sum = 0;

            for(int i=0; i<n; i++){
                sum+=combination(n-1,i)*pm[i];
            }

            if (sum == f) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                flag=true;
            }
        }

        else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L]=i;
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }

    static int combination(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0)    return 1;
        else return dy[n][r]=combination(n-1,r-1)+combination(n-1,r);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        f=sc.nextInt();

        pm=new int[n];
        ch=new int[n+1];


        T.DFS(0);

    }
}
