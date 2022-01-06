import java.util.Scanner;

public class Main {
    public void solution(String str, int n){
        char[] answer= new char[n];
        int a;
        for(int i=0; i<n; i++){
            String s=str.substring(7*i,7*(i+1)).replace('#','1').replace('*','0');
            a=Integer.parseInt(s,2);
            answer[i]=(char)a;

        }

        for(int k=0; k<n;k++){
            System.out.print(answer[k]);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        T.solution(str,n);
    }
}
