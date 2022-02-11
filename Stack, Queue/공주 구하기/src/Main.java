import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int solution(int n, int k){
        int answer=0;
        int cnt=0;
        int tmp;
        Queue<Integer> qu = new LinkedList<>();
        for(int i=1; i<=n; i++){
            qu.add(i);
        }
        while(qu.size()!=1){
            tmp = qu.poll();
            cnt++;
            if(cnt%k!=0)    qu.add(tmp);
        }
        answer=qu.poll();
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n,k));
    }
}
