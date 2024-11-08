import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, Integer> map;
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb =  new StringBuilder();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1);

            }
            // 경우의 수 계산
            int caseCount = 1;
            for (int count : map.values()) {
                caseCount *= (count + 1); // 해당 종류의 아이템을 안 입는 경우(+1)를 포함
            }

            // 모든 아이템을 안 입는 경우 하나를 제외해야 하므로 최종 경우의 수에서 1을 뺌
            caseCount -= 1;
            sb.append(caseCount).append("\n");


        }

        System.out.println(sb);
    }
}
