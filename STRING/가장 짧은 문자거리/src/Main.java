import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public void solution(String str, char c){
        ArrayList<Integer> answer = new ArrayList<>();
        char[] ch = str.toCharArray();
        int lmin,rmin;
        lmin=rmin=str.length()+1;

        for(int i=0; i<str.length(); i++){
            for(int j=i; j>=0; j--){
                if(ch[j]==c) {
                    lmin = (i - j);
                    break;
                }
            }
            for(int k=i; k<str.length(); k++){
                if(ch[k]==c){
                    rmin=(k-i);
                    break;
                }
            }

            answer.add(Math.min(lmin,rmin));
            lmin=rmin=str.length()+1;

        }

        for(int i=0; i<str.length(); i++){
            System.out.print(answer.get(i)+" ");
        }




    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        T.solution(str,c);
    }
}
