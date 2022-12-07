import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[b+1];

        arr[0]=arr[1]=1;
        for(int i=2; i<=Math.sqrt(b); i++){
            if(arr[i]==1)   continue;
            for(int j=2*i; j<=b; j=j+i){
                arr[j]=1;
            }
        }


        for(int i=a; i<=b; i++){
            if(arr[i]==0) System.out.println(i);
        }
    }
}
