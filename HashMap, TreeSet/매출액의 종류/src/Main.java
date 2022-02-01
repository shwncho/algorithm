import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> solution(int n, int k, int[] a){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> test = new HashMap<>();
        int s=0,e;
        for(e=0; e<n; e++){
            test.put(a[e],test.getOrDefault(a[e],0)+1);
            if(e>=k-1){
                answer.add(test.size());
                if(test.get(a[s])==1) {
                    test.remove(a[s]);
                }
                else{
                    test.put(a[s],test.get(a[s])-1);
                }
                s++;
            }

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
        for(int x:solution(n,k,arr)){
            System.out.print(x+" ");
        }

    }
}
