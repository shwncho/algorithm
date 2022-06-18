import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[1000001];
        arr[0]=arr[1]=1;
        boolean isProve=false;

        for(int i=2; i<=Math.sqrt(1000000); i++){
            if(arr[i]==1)   continue;
            for(int j=2*i; j<=1000000; j=j+i){
                arr[j]=1;
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            for (int i = 3; i <= n / 2; i = i + 2) {
                if (arr[i] == 0 && arr[n - i] == 0) {
                    bw.write(n + " = " + i + " + " + (n - i) + "\n");
                    isProve = true;
                    break;
                }
            }
            if (!isProve) bw.write("Goldbach's conjecture is wrong.");
        }

        br.close();
        bw.close();



    }
}
