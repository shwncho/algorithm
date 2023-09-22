import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,String> numVsName = new HashMap<>();
        Map<String,String> nameVsNum = new HashMap<>();

        for(int i=1; i<=n; i++){
            String name = br.readLine();
            String num = String.valueOf(i);
            numVsName.put(num, name);
            nameVsNum.put(name, num);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String target = br.readLine();
            if(Character.isDigit(target.toCharArray()[0]))    sb.append(numVsName.get(target)).append("\n");
            else    sb.append(nameVsNum.get(target)).append("\n");
        }
        System.out.println(sb);
    }
}