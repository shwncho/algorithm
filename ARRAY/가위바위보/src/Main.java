import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public String solution(int[] a, int[] b, int n){
        String answer = "";
        for(int i=0; i<n; i++){
            if(a[i]==b[i])  answer+="D";
            else if(a[i]==1 && b[i]==3) answer+="A";
            else if(a[i]==2 && b[i]==1) answer+="A";
            else if(a[i]==3 && b[i]==2) answer+="A";
            else{
                answer+="B";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i]=sc.nextInt();
        }

        for(int j=0; j<n; j++){
            b[j]=sc.nextInt();
        }

        for(char x: T.solution(a,b,n).toCharArray()){
            System.out.println(x);
        };
    }
}
