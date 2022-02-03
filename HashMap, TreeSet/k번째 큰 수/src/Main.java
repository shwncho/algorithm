import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int solution(int n, int k, int[] arr){
        int answer=0;
        int p=0,e;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> t;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for (int s=j+1; s<n; s++){
                    sum+=arr[i]+arr[j]+arr[s];
                    map.put(sum, map.getOrDefault(sum,0)+1);
                    sum=0;
                }

            }
        }

        if(map.size()<k)    answer=-1;
        else{
            t=new ArrayList<>(map.keySet());
            t.sort(Comparator.reverseOrder());
            answer=t.get(k-1);
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
