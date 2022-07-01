import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int n,t;
    static HashMap<Integer,Integer> hs=new HashMap<>();
    static int answer=0;
    static int[] arr;
    public void DFS(int L, int score, int time){
        if(L==n){
            if( t>=time && score>answer)    answer=score;
        }
        else{
            DFS(L+1, score+arr[L],time+hs.get(arr[L]));
            DFS(L+1,score,time);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        t=sc.nextInt();

        arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            hs.put(arr[i],sc.nextInt());
        }


        T.DFS(0,0,0);
        System.out.println(answer);



    }
}
