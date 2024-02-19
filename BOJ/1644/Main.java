import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        boolean[] isPrime = new boolean[N+1];
        for(int i=2; i<=N; i++){
            if(!isPrime[i]){
                numbers.add(i);
                for(int j=i*2; j<=N; j=j+i) isPrime[j]=true;
            }
        }

        System.out.println(solve(numbers,N));
    }
    private static int solve(List<Integer> numbers, int N){
        if(N==1)    return 0;

        int cnt = 0;
        int lt=0, rt=0, sum=0;

        while(lt < numbers.size() && rt < numbers.size()){
            if(sum==N){
                cnt++;
                sum-=numbers.get(lt++);
            }
            else if(sum>N){
                sum-=numbers.get(lt++);
            }
            else{
                sum+=numbers.get(rt++);
            }
        }

        //N이 소수인 경우
        if(numbers.get(numbers.size()-1)==N)    cnt++;
        return cnt;
    }
}
