import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        System.out.println(solution(A,T,target));

    }

    private static int solution(int A, int T, int target){
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        int n = 0;
        int answer = 0;
        while(true){
            n++;
            list = new ArrayList<>(Arrays.asList(0,1,0,1));
            for(int i=0; i<n+1; i++)    list.add(0);
            for(int i=0; i<n+1; i++)    list.add(1);

            for(int value : list){
                if(value==target)   cnt++;
                if(cnt==T){
                    return answer;
                }
                answer++;
                answer%=A;
            }
        }
    }
}
