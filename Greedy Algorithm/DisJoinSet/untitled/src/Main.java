import java.util.Scanner;

public class Main {
    static int[] unf;
    static int Find(int v){
        if(v==unf[v])   return v;
        else return unf[v]=Find(unf[v]);
    }
    static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)  unf[fa]=fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int j=1; j<=m; j++){
            int a =sc.nextInt();
            int b =sc.nextInt();
            Union(a,b);
        }
        int c = sc.nextInt();
        int d = sc.nextInt();
        int fc = Find(c);
        int fd = Find(d);
        if(fc==fd) System.out.println("YES");
        else System.out.println("NO");
    }
}
