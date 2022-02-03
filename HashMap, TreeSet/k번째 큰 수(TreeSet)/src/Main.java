import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static int solution(int n, int k, int[] arr){
        int answer=-1;
        // Collections.reverseOrder 없으면 자동으로 오름차순, 중복제거+순서를 보장하고 싶을 때 TreeSet을 사용한다.
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        // n-2,n-1,n 으로 범위의 끝을 정해줘도 되지만 i가 n-1 또는 n의 위치일경우 j=i+1, s=j+1이기 때문에 자동으로 false이기 때문에 신경안써도 된다.
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int s=j+1; s<n; s++){
                    Tset.add(arr[i]+arr[j]+arr[s]);
                }
            }
        }
        int cnt=0;
        for(int x:Tset){
            cnt++;
            if(cnt==k)  return x;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(solution(n,k,arr));
    }
}
