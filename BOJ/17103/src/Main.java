import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[1000001];
        arr[0]=arr[1]=1;

        for(int i=2; i<=Math.sqrt(1000000); i++){
            if(arr[i]==1)   continue;
            for(int j=2*i; j<=1000000; j=j+i){
                arr[j]=1;
            }
        }

        int n = Integer.parseInt(br.readLine());
        int t;
        int cnt=0;
        for(int i=0; i<n; i++){
            t=Integer.parseInt(br.readLine());
            for(int j=2; j<=t/2; j++){
                if(arr[j]==0 && arr[t-j]==0)  cnt++;
            }
            bw.write(cnt+"\n");
            cnt=0;
        }

        br.close();
        bw.close();

    }
}
