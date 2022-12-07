import java.util.Scanner;

public class Main {
    public static int[] solution(int n, int[] arr){
        int tmp=0;
        for(int i=0; i<n-1; i++){
            for(int j=1; j<n; j++){
                if(arr[j]<arr[j-1]){
                    tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        for(int x:solution(n,arr)){
            System.out.print(x+" ");
        }
    }
}
