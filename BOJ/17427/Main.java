import java.io.*;

/**
 * 1. 약수를 빠르게 구하는 방법은 sqrt를 이용한다.
 * 2. 이 문제에서는 어떤 수의 약수들의 총합을 구하므로 약수를 일일이 구할필요없이 1부터 N까지 몇개씩 있는지만 알고 더하면 된다.
 * 3. 주어진 수의 범위를 확인하고 int,long을 고르는 것도 생각하자
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long sum=0;

        for(int i=1; i<=N; i++){
            //N의 약수중 i를 약수로 갖는 수의 개수*i의 합을 1~N까지 누적
            sum+=i*(N/i);
        }
        bw.write(String.valueOf(sum));

        br.close();
        bw.close();

    }
}
