import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public int solution(int[][] arr, int n){
        int answer=Integer.MIN_VALUE;
        int rs,cs;  // rs=rowsum, cs=columnsum
        int ds1=0,ds2=0; // ds1은 왼쪽대각선의 합, ds2는 오른쪽 대각선의 합
        for(int i=0; i<n; i++){
            rs=cs=0;
            for(int j=0; j<n; j++){
                rs+=arr[i][j];
                cs+=arr[j][i];
            }
            answer=Math.max(answer,rs);
            answer=Math.max(answer,cs);
            ds1+=arr[i][i];
            ds2+=arr[i][n-i-1];
        }
        answer=Math.max(answer,ds1);
        answer=Math.max(answer,ds2);

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(T.solution(arr,n));
    }
}
