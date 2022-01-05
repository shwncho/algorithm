import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer ="";

        int cnt=0;
        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)) cnt++;

                else{
                    break;
                }

            }
            if(cnt>=2){
                answer+=str.charAt(i)+(cnt+"");
                i+=cnt-1;
            }
            else{
                answer+=str.charAt(i);
            }
            cnt=0;
        }


        return answer;

        /*
        다른 풀이
        String answer="";
        s=s+" ";
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer+=s.charAt(i);
                if(cnt>1)   answer+=String.valueOf(cnt);
                cnt=1;
            }
        }
        return answer;
         */
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
