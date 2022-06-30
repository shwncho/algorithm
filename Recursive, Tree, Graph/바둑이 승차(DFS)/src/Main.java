import java.util.Scanner;

public class Main {
    static int max=0;
    static int n,w;
    public void DFS(int L,int sum, int[] arr){
        if(L==n){
            if(sum>=max && w>=sum)  max=sum;
        }
        else{
            DFS(L+1,sum+arr[L],arr);
            DFS(L+1,sum,arr);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        w=sc.nextInt();
        n=sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        T.DFS(0,0,arr);
        System.out.println(max);


    }
}
