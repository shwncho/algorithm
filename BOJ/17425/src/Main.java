import java.io.*;
import java.util.Arrays;

/**
 * 약수의 문제에서 빠른 시간안에 풀고자한다면 배수 아이디어를 생각해라
 * 시간은 짧은데 메모리를 더 준다면 메모리를 활용해서 생각
 * i=2, j=1~500,000까지 2를 약수로 가지는 수(i*j)들에 2를 저장한다.
 * 예를 들어, (i,j)에서 i*j=4 이면 (2,2)와 (4,1)이 f(4)에 2와 4를 더한다.(1은 기존에 다 더해놨으므로)
 */
public class Main {
    static final int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] fx = new long[MAX];
        long[] gx = new long[MAX];
        int[] arr = new int[N];
        int value;

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        //입력받은 수들중 최대값까지만 약수받기
        value=Arrays.stream(arr).max().getAsInt();

        //1은 모든 수의 약수이므로 미리 채우기
        Arrays.fill(fx,1);

        //2부터 최대값까지 배수들을 이용해 약수의 합을 채워넣기
        for(int i=2; i<=value; i++){
            for(int j=1; i*j<=value; j++){
                fx[i*j]+=i;
            }
        }

        //f(x)의 누적합을 할당
        for(int i=1; i<=value; i++){
            gx[i]=gx[i-1]+fx[i];
        }

        for(int idx:arr){
            bw.write(String.valueOf(gx[idx])+"\n");
        }

        br.close();
        bw.close();
    }
}
