import java.util.*;

public class Main {
    static int n,sum1=0,sum2=0,L=0;
    static int[] ch;
    static int[] arr;
    static String answer="NO";

    public void DFS(int L){
        if(L==n){
            for(int i=0; i<n; i++){
                if(ch[arr[i]]==1)   sum1+=ch[arr[i]];
                else    sum2+=arr[i];

            }
            if(sum1==sum2)  answer="YES";
            sum1=0;
            sum2=0;
        }

        else{
            ch[arr[L]]=1;
            DFS(L+1);
            ch[arr[L]]=0;
            DFS(L+1);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        ch=new int[100001];
        arr=new int[n];


        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);

        T.DFS(L);
        System.out.println(answer);
    }
}
