import java.util.Scanner;

public class Main {
    public int[] solution(int[] arr1, int[] arr2){
        int len=arr1.length+arr2.length;
        int[] answer= new int[len];
        int p=0,k=0;
        for(int i=0; i<len; i++){
            if(p==arr1.length){
                answer[i]=arr2[k];
                k++;
                continue;
            }
            else if(k==arr2.length){
                answer[i]=arr1[p];
                p++;
                continue;
            }

            if(arr1[p]<arr2[k]){
                answer[i]=arr1[p];
                p++;
            }
            else{
                answer[i]=arr2[k];
                k++;
            }
        }




        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i]=sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int j=0; j<m; j++){
            arr2[j]=sc.nextInt();
        }
        for(int x:T.solution(arr1,arr2)){
            System.out.print(x+" ");
        };

    }
}
