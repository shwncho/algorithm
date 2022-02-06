import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int solution(int n, int m, int[][] arr1, int[] arr2){
        int answer=0;
        int tmp;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr1[j][arr2[i]-1]!=0){
                    tmp=arr1[j][arr2[i]-1];
                    if(!(stk.isEmpty()) && stk.peek()==tmp){
                        stk.pop();
                        answer+=2;
                    }
                    else    stk.push(tmp);
                    arr1[j][arr2[i]-1]=0;
                    break;
                }

            }
        }


        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] arr1 = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr1[i][j]=sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int k=0; k<m; k++){
            arr2[k]=sc.nextInt();
        }
        System.out.println(solution(n,m,arr1,arr2));
    }
}
