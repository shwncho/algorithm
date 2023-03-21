import java.io.*;

public class Main {
    final static long MOD = 1_000_000_007;
    static long[][] origin = {{1,1},{1,0}}; // 초기값 행렬
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long[][] A = {{1,1},{1,0}};

        System.out.println(pow(A,n-1)[0][0]);
    }

    //행렬 제곱 분할정복 메서드
    public static long[][] pow(long[][] A, long exp){

        //지수가 1 또는 0 일 때 return
        if(exp==1 || exp ==0){
            return A;
        }

        //지수를 절반으로 분할하여 재귀 호 => 거듭제곱 최적화 , O(N)을 O(logN)으로 줄어듦
        long[][] ret = pow(A,exp/2);

        ret = multiply(ret,ret);

        //지수가 홀수 일경우 origin 곱해야 한다
        // ex) A^5 => A* (A^2)^2
        if(exp % 2 ==1L){
            ret = multiply(ret, origin);
        }

        return ret;

    }

    public static long[][] multiply(long[][] o1, long[][] o2){
        long[][] ret = new long[2][2];

        for(int k=0; k<2; k++){
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    ret[i][j]+=o1[i][k]*o2[k][j];
                    ret[i][j]%=MOD;
                }
            }
        }

        return ret;
    }
}
