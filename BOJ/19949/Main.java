import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int[] answer = new int[10];
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10; i++) answer[i] = Integer.parseInt(st.nextToken());


        DFS(0);
        System.out.println(result);

    }

    public static void DFS(int L){
        if(L==10){
            int cnt = 0;
            for(int i=0; i<10; i++){
                if(arr[i] == answer[i]) cnt++;
            }

            if(cnt>=5)  result++;
        }

        else{
            for(int i=1; i<6; i++){
                if(L>=2){
                    if(arr[L-1]==i && arr[L-2]==i)  continue;
                }
                arr[L] = i;
                DFS(L+1);
            }
        }
    }
}
