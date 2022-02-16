import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int count(int[] arr, int dist){
        int cnt = 1;
        int ep=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep>=dist){
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }
    public static int solution(int n, int c, int[] arr){
        int answer=0;
        Arrays.sort(arr);
        int lt=1;   //lt가 1인 이유, 가장 가까운 거리의 최솟값이 1부터 시작하므로 arr[0]을 설정해주는 것과 다른 개념이다.
        int rt=arr[n-1];    //rt가 arr[n-1]인 이유 이분탐색은 nlog2n이기 때문에 max-min을 한 것과 별 차이가 없다고 하심
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr,mid)>=c){
                answer=mid;
                lt=mid+1;
            }
            else    rt=mid-1;
        }





        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++)  arr[i]=sc.nextInt();
        System.out.println(solution(n,c,arr));
    }
}
