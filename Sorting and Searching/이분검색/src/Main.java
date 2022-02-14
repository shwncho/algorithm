import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int solution(int n, int m, int[] arr){
        int answer=0;
        Arrays.sort(arr);
        int low=0,high=arr.length-1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]>m){
                high=mid-1;
            }
            else if(arr[mid]<m){
                low=mid+1;
            }
            else{
                answer=mid;
                break;
            }
        }
        //인덱스가 아닌 위치를 출력하므로 +1
        answer++;
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(solution(n,m,arr));
    }
}
