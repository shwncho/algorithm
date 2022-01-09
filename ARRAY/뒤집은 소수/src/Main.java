import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int[] arr, int n){
        ArrayList<Integer> answer= new ArrayList<>();
        boolean isPrime=true;
        for(int i=0; i<n; i++){
            int result=0;
            while(arr[i]>0){
                result=result*10+arr[i]%10;
                arr[i]=arr[i]/10;
            }
            arr[i]=result;
            for(int j=2; j<arr[i]; j++){
                if(arr[i]%j==0) isPrime=false;
            }
            if(arr[i]==1)   isPrime=false;
            if(isPrime) answer.add(arr[i]);
            isPrime=true;

        }



        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x:T.solution(arr,n)){
            System.out.print(x+" ");
        }
    }
}
