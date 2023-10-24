import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals("end")) break;

            if(!check1(s)){
                sb.append("<"+s+">"+" is not acceptable.").append("\n");
                continue;
            }

            if(!check2(s)){
                sb.append("<"+s+">"+" is not acceptable.").append("\n");
                continue;
            }

            if(!check3(s)){
                sb.append("<"+s+">"+" is not acceptable.").append("\n");
                continue;
            }

            sb.append("<"+s+">"+" is acceptable.").append("\n");

        }

        System.out.println(sb);
    }
    // 모음 1개 이상인지
    public static boolean check1(String s){
        char[] chars = s.toCharArray();

        for(char x : chars){
            if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u')  return true;
        }
        return false;
    }
    //모음이 3개 혹은 자음이 3 연속으로 오는지
    public static boolean check2(String s){
        char[] chars = s.toCharArray();
        // 모음이 3개 연속오는지
        int cnt1 = 0;
        // 자음이 3개 연속오는지
        int cnt2 = 0;
        for(char x : chars) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                cnt1++;
                cnt2 = 0;
            } else {
                cnt2++;
                cnt1 = 0;
            }

            if (cnt1 == 3 || cnt2 == 3) return false;
        }

        return true;
    }

    //ee나 oo를 제외하고 같은 문자가 연속으로 2개오는지
    public static boolean check3(String s){
        char[] chars = s.toCharArray();

        for(int i=1; i<chars.length; i++){
            if(chars[i]!='e' && chars[i]!='o'){
                if(chars[i]==chars[i-1])    return false;
            }
        }

        return true;
    }
}
