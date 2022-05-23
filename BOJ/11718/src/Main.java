import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        while(true){
            String s = br.readLine();
            //문자열이 "" or " "인 경우는 isBlank로 잡을 수 있지만, null은 따로 체크 해줘야한다.
            //이 문제에서는 문자입력 없을 때 그냥 null임
            if(s==null || s.isBlank()) break;
            sb.append(s).append("\n");

        }
        System.out.println(sb);
        br.close();



    }
}
