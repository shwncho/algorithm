import java.util.Scanner;

public class Main {
    public String solution(String str){
        // 정규식이용 풀이
        String answer="NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer="YES";

        return answer;


        /* 내 풀이
        String answer="YES";
        char[] c = str.toCharArray();
        int lt=0, rt=str.length()-1;

        while(lt<rt){
            if(!(Character.isAlphabetic(c[lt]))){
                lt++;
            }

            else if(!(Character.isAlphabetic(c[rt]))){
                rt--;
            }

            else{
                if(Character.toLowerCase(c[lt])==Character.toLowerCase(c[rt])){
                    lt++;
                    rt--;
                }
                else{
                    return "NO";
                }
            }

        }

        return answer;

         */
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
