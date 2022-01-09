import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public int solution(ArrayList<Integer>[][]arr, int n){
        int answer;
        int rm=0,cm=0,ds1=0,ds2=0,a=4;
        int max1,max2;

        for(int i=0; i<n; i++){
            for(int j=0; j<; j++){
                rm=Collections.max(arr[i]);
            }

            ds1+=arr[i][i];
            ds2+=arr[i][a--];

        }
        max1=rm>cm ? rm : cm;
        max2=ds1>ds2 ? ds1 : ds2;
        answer=max1>max2 ? max1 : max2;


        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[][] arr = new ArrayList[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j].add(sc.nextInt());
            }
        }
        System.out.println(T.solution(arr,n));
    }
}
