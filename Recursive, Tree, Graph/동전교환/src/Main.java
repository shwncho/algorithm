import java.util.Scanner;

public class Main {
    static int n,change,answer=Integer.MAX_VALUE;
    static int[] ch;
    public void DFS(int L, int sum){
        if(sum>change)  return;
        if(L>=answer)   return;
        if (sum == change) {
            answer=Math.min(answer,L);
        }
        else{
            for(int i=n-1; i>=0; i--){
                DFS(L+1,sum+ch[i]);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        ch=new int[n];

        for(int i=0; i<n; i++){
            ch[i]=sc.nextInt();
        }

        change=sc.nextInt();
        T.DFS(0,0);
        System.out.println(answer);
    }
}
