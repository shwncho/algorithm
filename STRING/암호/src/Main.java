import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public void solution(String str){
        String answer="";
        String s="";
        ArrayList<String> arr = new ArrayList<String>();
        int cnt=0;
        for(int i=0; i<str.length(); i++){
            cnt++;
            if(str.charAt(i)=='#')  s+="1";
            else    s+="0";

            if(cnt==7){
                arr.add(s);
                cnt=0;
                s="";
            }

        }
        for(int i=0; i<arr.size(); i++){
            int a=Integer.parseInt(arr.get(i),2);
            char c =(char)a;
            System.out.print(c);
        }




    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        String str =sc.next();
        T.solution(str);

    }
}
